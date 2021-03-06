package test.misc;

import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

import java.util.ArrayList;

import misc.ExecutionHandler;
import misc.MessageCategories;
import misc.MessageSystem;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.FunctionCallNotAllowedException;
import parser.IllegalTypeException;

import ast.ArithmeticExpression;
import ast.Assumption;
import ast.Division;
import ast.Ensure;
import ast.Function;
import ast.FunctionParameter;
import ast.IntegerType;
import ast.NumericLiteral;
import ast.Position;
import ast.Program;
import ast.StatementBlock;
import ast.VariableDeclaration;

import static org.junit.Assert.*;

public class ExecutionHandlerTest {
    private ExecutionHandler executionHandler;
    
    @Before
    public void setUp() {
        executionHandler = new ExecutionHandler(new MessageSystem());
    }

    @After
    public void tearDown() {
        executionHandler = null;
    }
    
    @Test
    public void testLoop() {
        executionHandler.parse("main() {int i; int limit=1000; while (i<limit)" +
                "invariant i>= 0;{i=i+1;}ensure i>= 0;}" +
        		"ensure i == limit;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testArrayEqual() {
        executionHandler.parse("main() {bool[] x = array[3];" +
                "bool[] y = array[3];} ensure x == y;");
        executionHandler.run(null, null);
        assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testArrayNotEqualValues() {
        executionHandler.parse("main() {bool[] x = array[3];" +
                "bool[] y = array[3]; y[2] = true;} ensure x != y;");
        executionHandler.run(null, null);
        assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testArrayNotEqualLength() {
        executionHandler.parse("main() {bool[] x = array[3];" +
                "bool[] y = array[4];} ensure x != y;");
        executionHandler.run(null, null);
        assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testDivision() {
        executionHandler.parse("main() {assert 4/2==2; assert 5/3==1;" +
                "assert (-4)/2==-2; assert (-5)/3==-2;" +
                "assert 4/(-2)==-2; assert 5/(-3)==-1;" +
                "assert (-4)/(-2)==2; assert (-5)/(-3)==2;}");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testModulo() {
        executionHandler.parse("main() {assert 4%2==0; assert 5%3==2;" +
                "assert (-4)%2==0; assert (-5)%3==1;" +
                "assert 4%(-2)==0; assert 5%(-3)==2;" +
                "assert (-4)%(-2)==0; assert (-5)%(-3)==1;}");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testIf() {
        executionHandler.parse("main() {int i; if (i<2)" +
                "{int i = -1;}}" +
                "ensure i == 00000;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testIfElse() {
        executionHandler.parse("main() {int i; if (i>2) {int i = -1;}" +
                "else {i=2;}}" +
                "ensure i == 000002;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testParams() {
        executionHandler.parse("main(int i, int[][] r)" +
                "{int j = 0; while (j < length(r)){i=i+r[j][0]; j=j+1;}}" +
                "ensure i == 42;");
        executionHandler.setParameterValues(
                new String[]{"2", "{{20},{11},{9}}"});
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testArraySum() {
        executionHandler.parse("int sum(int[] i){int j = 0;int res = 0;" +
                "while(j<length(i)){res = res+i[j]; j=j+1;} return res;}" +
                "main() {int[] x = array[3]; x[0]=2;x[1]=-1;x[2]=2;" +
                "int h = sum(x);} ensure h == 3;");
        executionHandler.run(null, null);
        assertNull(executionHandler.getAssertionFailureMessage());
    }
    
    @Test
    public void testEmptyProgramEnsureTrue() {
        executionHandler.parse("main(){} ensure true;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testAssignmentAndEnsure() {
        executionHandler.parse("main() {int x = 1;} ensure x > 0;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testQuantifiers() {
        executionHandler.parse("main()" +
                "{int j = 4;}" +
                "ensure forall x(2,j) exists z(1,2) (j==x+z) | (j==x*z);");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testRecursion() {
        executionHandler.parse("int rek(int n, int k) assume {n >= k; k >= 0;} {" +
                    "int result = 1;" +
                    "if ((n != k) & (k != 0) & (n != 0)) {" +
                            "result = rek(n-1, k-1)+rek(n-1, k);" +
                    '}' +
                    "return result;" +
                    '}' +
                    "main(){" +
                            "int n=4;int k=2;" +
                            "int f = rek(n,k);" +
                    "} ensure f==6;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testArrays() {
        executionHandler.parse("main() {" +
                    "int n = 5; int k = 3; int r = 10;" +
                    "int[][] table = array[n+1][k+1];" +
                    "int i=0; while (i<=n) {" +
                        "int j=0; while ((j<=i) & (j <= k)) {" +
                            "if ((i == j) | (i == 0) | (j == 0)) {" +
                            "table[i][j] = 1;} else {" +
                            "assert (i-1>=0)&(j-1>=0)&(j<=k);" +
                    "table[i][j] = table[i-1][j-1]+table[i-1][j];}" +
                            "j=j+1;" +
                        "}i=i+1;" +
                    "}} ensure table[n][k] == r;");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testEmptyProgram() {
        executionHandler.parse("main(){}");
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testAssumptions() {
        executionHandler.parse("main(bool i) assume i; {}");
        executionHandler.setParameterValues(
                new String[]{"true"});
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testNegation() {
        executionHandler.parse("main(bool i) {}ensure !i;");
        executionHandler.setParameterValues(
                new String[]{"false"});
        executionHandler.run(null, null);
		assertNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testEmptyExists() {
        executionHandler.parse("main() {}ensure exists h() false;");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testAssumptionsFail() {
        executionHandler.parse("main(bool i) assume i; {}");
        executionHandler.setParameterValues(
                new String[]{"false"});
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testQuantifierFail() {
        executionHandler.parse("main()" +
                "{int j = 4;}" +
                "ensure forall x(2,j) exists z(1,2) (j==x*z);");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testDivZero() {
        executionHandler.parse("main()" +
                "{int j = 4; j = j/(j-4);}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testArrayLength() {
        executionHandler.parse("main()" +
                "{int[][][] j = array[2][0][3];}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testArrayIndexRead() {
        executionHandler.parse("main()" +
                "{int[][][] j = array[2][1][3]; int i = j[2][0][1];}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testArrayIndexAssign() {
        executionHandler.parse("main()" +
        		"{int[][][] j = array[2][1][3]; j[1][-1][1] = 2;}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testModuloZero() {
        executionHandler.parse("main()" +
                "{int j = 2%0;}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testExistsFail() {
        executionHandler.parse("main()" +
                "{int j = 4;}" +
                "ensure exists z(1,2) (j==3*z);");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testForAllFail() {
        executionHandler.parse("main()" +
                "{int j = 4;}" +
                "ensure forall x() (j==x*2);");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testEmptySetExistsFail() {
        executionHandler.parse("main()" +
                "{int j = 4;}" +
                "ensure exists z(j,2) true;");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testInvariantFailMiddle() {
        executionHandler.parse("main()" +
                "{int j = 4; while (j < 20) invariant j != 15; {j=j+1;}}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testInvariantFailBeginning() {
        executionHandler.parse("main()" +
                "{int j = 4; while (j < 20) invariant j > 4; {j=j+1;}}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testInvariantFailEnd() {
        executionHandler.parse("main()" +
                "{int j = 4; while (j < 20) invariant j < 20; {j=j+1;}}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testEmptyProgramEnsureFalse() {
        executionHandler.parse("main(){} ensure false;");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testAssumeFalse() {
        executionHandler.parse("main() assume false;{}");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testRecursionFail() {
        executionHandler.parse("int rek(int n, int k) assume {n >= k; k >= 0;} {" +
                    "int result = 1;" +
                    "if ((n != k) & (k != 0) & (n != 0)) {" +
                            "result = rek(n-1, k-1)+rek(n-1, k);" +
                    '}' +
                    "return result;" +
                    '}' +
                    "main(){" +
                            "int n=4;int k=2;" +
                            "int f = rek(n,k);" +
                    "} ensure f==5;");
        executionHandler.run(null, null);
		assertNotNull(executionHandler.getAssertionFailureMessage());
	}

    @Test
    public void testArraysFail() {
        executionHandler.parse("main() {" +
                    "int n = 5; int k = 3; int r = 9;" +
                    "int[][] table = array[n+1][k+1];" +
                    "int i=0; while (i<=n) {" +
                        "int j=0; while ((j<=i) & (j <= k)) {" +
                            "if ((i == j) | (i == 0) | (j == 0)) {" +
                            "table[i][j] = 1;} else {" +
                            "assert (i-1>=0)&(j-1>=0)&(j<=k);" +
                    "table[i][j] = table[i-1][j-1]+table[i-1][j];}" +
                            "j=j+1;" +
                        "}i=i+1;" +
                    "}} ensure table[n][k] == r;");
        executionHandler.run(null, null);
        assertNotNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testMethodAssumeFail() {
        executionHandler.parse("int f(int i) assume i>0;{return 0;}" +
                "main() {int x = f(-2);} ensure x > 0;");
        executionHandler.run(null, null);
        assertNotNull(executionHandler.getAssertionFailureMessage());
    }
    
    @Test
    public void testArrayParameterFail() {
        executionHandler.parse("int f(int[] i) assume length(i) > 3;{return 0;}" +
                "main() {int[] x = array[3]; x[1] = f(x);} ensure x[1] > 0;");
        executionHandler.run(null, null);
        assertNotNull(executionHandler.getAssertionFailureMessage());
    }

    @Test
    public void testArraySumFail() {
        executionHandler.parse("int sum(int[] i){int j = 0;int res = 0;" +
                "while(j<length(i)){res = res+i[j]; j=j+1;} return res;}" +
                "main() {int[] x = array[3]; x[0]=2;x[1]=-1;x[2]=2;" +
                "int h = sum(x);} ensure h < 0;");
        executionHandler.run(null, null);
        assertNotNull(executionHandler.getAssertionFailureMessage());
    } 
}
