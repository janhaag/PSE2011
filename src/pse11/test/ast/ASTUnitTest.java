package test.ast;

import static org.junit.Assert.*;

import org.junit.Test;

import ast.*;

public class ASTUnitTest {	
	
	@Test
	public void testSimpleProgram() {
		Statement[] mainStatements = new Statement[1];
		mainStatements[0] = STANDARDSTATEMENT;
		StatementBlock mainBody = new StatementBlock(mainStatements, POSITION);
		FunctionParameter[] mainParameters = new FunctionParameter[0];
		Assumption[] mainAssumptions = new Assumption[0];
		Ensure[] mainEnsures = new Ensure[0];
		Function mainFunction = new Function(POSITION, new IntegerType(), "main", mainParameters, mainBody, mainAssumptions, mainEnsures);
		Axiom[] mainAxioms = new Axiom[0];
		Function[] functions = new Function[0];
		Program testProgram = new Program(POSITION, functions, mainFunction, mainAxioms);
		String testString = "int main() "
			+"{\n"
			+"int testvar = 0;\n"
			+"}";
		assertEquals(testString, testProgram.toString());
		assertEquals(POSITION, testProgram.getPosition());
	}
	
	@Test
	public void testLoop() {
		LogicalExpression testCondition = new LogicalExpression(POSITION, new VariableRead(POSITION, new Identifier("testvar")), new NumericLiteral(POSITION, "42"), new GreaterEqual());
		Statement[] loopStatements = new Statement[2];
		loopStatements[0] = STANDARDSTATEMENT;
		loopStatements[1] = STANDARDSTATEMENT;
		StatementBlock loopBlock = new StatementBlock(loopStatements, POSITION);
		Invariant[] loopInvariants = new Invariant[2];
		loopInvariants[0] = new Invariant(POSITION, STANDARDEXPRESSION);
		loopInvariants[1] = new Invariant(POSITION, STANDARDEXPRESSION);
		Ensure[] loopPostconditions = new Ensure[2];
		loopPostconditions[0] = new Ensure(POSITION, STANDARDEXPRESSION);
		loopPostconditions[1] = new Ensure(POSITION, STANDARDEXPRESSION);
		Loop testLoop = new Loop(POSITION, testCondition, loopBlock, loopInvariants, loopPostconditions);
		String testString = "while ((testvar >= 42))\n"
			+"invariant testvar;\ninvariant testvar;\n"
			+"{\n"
			+"int testvar = 0;\nint testvar = 0;\n"
			+"}\n"
			+"ensure testvar;\nensure testvar;\n";
		assertEquals(testString, testLoop.toString());
	}
	
	@Test
	public void testConditional() {
		Statement[] trueStatements = new Statement[0];
		Statement[] falseStatements = new Statement[0];
		StatementBlock trueCondition = new StatementBlock(trueStatements, POSITION);
		StatementBlock falseCondition = new StatementBlock(falseStatements, POSITION);
		Conditional testConditional = new Conditional(POSITION, STANDARDCONDITION, trueCondition, falseCondition);
		String testString = "if ((testvar >= 42)) {\n"
			+"} else {\n"
			+"}\n";
		assertEquals(testString, testConditional.toString());
	}
	
	@Test
	public void testCharacters() {
		assertEquals(">", new Greater().toString());
		assertEquals("<", new Less().toString());
		assertEquals("+", new Addition().toString());
		assertEquals("*", new Multiplication().toString());
		assertEquals("-", new Subtraction().toString());
		assertEquals("/", new Division().toString());
		assertEquals("%", new Modulo().toString());
		assertEquals("!", new Negation().toString());
		assertEquals("!=", new NotEqual().toString());
		assertEquals("-", new UnaryMinus().toString());
		assertEquals("==", new Equal().toString());
		assertEquals("<=", new LessEqual().toString());
		assertEquals("|", new Disjunction().toString());
		assertEquals("&", new Conjunction().toString());
	}
	
	@Test
	public void testTypes() {
		IntegerType intTest = new IntegerType();
		assertEquals("int", intTest.toString());
		assertTrue(intTest.equals(new IntegerType()));
		BooleanType boolTest = new BooleanType();
		assertEquals("bool", boolTest.toString());
		assertTrue(boolTest.equals(new BooleanType()));
		ArrayType arrayTest = new ArrayType(intTest);
		assertEquals(intTest, arrayTest.getType());
		assertTrue(arrayTest.equals(arrayTest));
		assertFalse(arrayTest.equals(null));
		assertFalse(arrayTest.equals(intTest));
		assertTrue(arrayTest.equals(new ArrayType(new IntegerType())));
		assertFalse(arrayTest.equals(new ArrayType(new BooleanType())));
		assertEquals("int[]", arrayTest.toString());
	}
	
	@Test
	public void testPositions() {
		Position positionTest = new Position(4, 2);
		assertEquals(4, positionTest.getLine());
		assertEquals(2, positionTest.getColumn());
		assertEquals(0, new Position().getLine());
		assertEquals(0, new Position().getColumn());
	}
	
	@Test
	public void testFunctionCall() {
		Expression[] functionParameters = new Expression[2];
		functionParameters[0] = STANDARDEXPRESSION;
		functionParameters[1] = STANDARDEXPRESSION;
		FunctionCall testFunction = new FunctionCall(new Identifier("testFunction"), new Expression[0], POSITION);
		String testString = "(testFunction())";
		assertEquals(testString, testFunction.toString());
		testFunction = new FunctionCall(new Identifier("testFunction"), functionParameters, POSITION);
		testString = "(testFunction(testvar, testvar))";
		assertEquals(testString, testFunction.toString());
		assertEquals(new Identifier("testFunction"), testFunction.getFunctionIdentifier());
		assertEquals(functionParameters.length, testFunction.getParameters().length);
		for(int i = 0; i < functionParameters.length; i++) {
			assertEquals(functionParameters[i], testFunction.getParameters()[i]);
		}
	}
	
	@Test
	public void testArrays() {
		Expression[] testIndices = new Expression[2];
		testIndices[0] = STANDARDEXPRESSION;
		testIndices[1] = STANDARDEXPRESSION;
		ArrayAssignment testAssignment = new ArrayAssignment(POSITION, STANDARDEXPRESSION, new Identifier("testvar"), testIndices);
		assertEquals("testvar[testvar][testvar] = testvar;\n", testAssignment.toString());
		assertEquals(testIndices.length, testAssignment.getIndices().length);
		for(int i = 0; i < testIndices.length; i++) {
			assertEquals(testIndices[i], testAssignment.getIndices()[i]);
		}
		
		ArrayDeclaration testDeclaration = new ArrayDeclaration(POSITION, "testvar", new IntegerType(), testIndices);
		assertEquals("int testvar[testvar][testvar];\n", testDeclaration.toString());
		assertEquals(testIndices.length, testDeclaration.getIndices().length);
		for(int i = 0; i < testIndices.length; i++) {
			assertEquals(testIndices[i], testDeclaration.getIndices()[i]);
		}
		
		ArrayRead testRead = new ArrayRead(POSITION, new Identifier("testvar"), testIndices);
		assertEquals("testvar[testvar][testvar]", testRead.toString());
		assertEquals(testIndices.length, testRead.getIndices().length);
		for(int i = 0; i < testIndices.length; i++) {
			assertEquals(testIndices[i], testRead.getIndices()[i]);
		}
	}
	
	@Test
	public void testQuantifiers() {
		Range testRange = new Range(STANDARDEXPRESSION, STANDARDEXPRESSION);
		assertEquals(STANDARDEXPRESSION, testRange.getUpperBound());
		assertEquals(STANDARDEXPRESSION, testRange.getLowerBound());
		
		ForAllQuantifier testForAll = new ForAllQuantifier(POSITION, null, new Identifier("testQuantifier"), STANDARDCONDITION);
		assertEquals("(forall testQuantifier() (testvar >= 42))", testForAll.toString());
		testForAll = new ForAllQuantifier(POSITION, testRange, new Identifier("testQuantifier"), STANDARDCONDITION);
		assertEquals("(forall testQuantifier(testvar, testvar) (testvar >= 42))", testForAll.toString());
		
		ExistsQuantifier testExists = new ExistsQuantifier(POSITION, null, new Identifier("testExistsQuantifier"), STANDARDCONDITION);
		assertEquals("(exists testExistsQuantifier() (testvar >= 42))", testExists.toString());
		testExists = new ExistsQuantifier(POSITION, testRange, new Identifier("testExistsQuantifier"), STANDARDCONDITION);
		assertEquals("(exists testExistsQuantifier(testvar, testvar) (testvar >= 42))", testExists.toString());
	}
	
	@Test
	public void testFunction() {
		FunctionParameter[] parameters = new FunctionParameter[2];
		parameters[0] = new FunctionParameter("parameter1", new IntegerType());
		assertEquals("parameter1", parameters[0].getName());
		assertEquals(new IntegerType(), parameters[0].getType());
		parameters[1] = new FunctionParameter("parameter2", new BooleanType());
		Statement[] statements = new Statement[3];
		statements[0] = STANDARDSTATEMENT;
		statements[1] = STANDARDSTATEMENT;
		statements[2] = new ReturnStatement(POSITION, STANDARDEXPRESSION);
		assertEquals(STANDARDEXPRESSION, ((ReturnStatement) statements[2]).getReturnValue());
		StatementBlock body = new StatementBlock(statements, POSITION);
		Assumption[] assumptions = new Assumption[2];
		assumptions[0] = new Assumption(POSITION, STANDARDCONDITION);
		assumptions[1] = new Assumption(POSITION, STANDARDCONDITION);
		Ensure[] ensures = new Ensure[2];
		ensures[0] = new Ensure(POSITION, STANDARDCONDITION);
		ensures[1] = new Ensure(POSITION, STANDARDCONDITION);
		Function testFunction = new Function(POSITION, null, "testFunction",
				parameters, body, assumptions, ensures);
		String testString = "testFunction(int parameter1, bool parameter2) {\n"
			+"assume (testvar >= 42);\nassume (testvar >= 42);\n"
			+"int testvar = 0;\nint testvar = 0;\n"
			+"return testvar;\n"
			+"ensure (testvar >= 42);\nensure (testvar >= 42);\n"
			+"}";
		assertEquals(testString, testFunction.toString());
		assertEquals("testFunction", testFunction.getName());
		assertEquals(body, testFunction.getFunctionBlock());
		assertEquals(parameters.length, testFunction.getParameters().length);
		for(int i = 0; i < parameters.length; i++) {
			assertEquals(parameters[i], testFunction.getParameters()[i]);
		}
		assertNull(testFunction.getReturnType());
		assertEquals(assumptions.length, testFunction.getAssumptions().length);
		for(int i = 0; i < assumptions.length; i++) {
			assertEquals(assumptions[i], testFunction.getAssumptions()[i]);
		}
		assertEquals(ensures.length, testFunction.getEnsures().length);
		for(int i = 0; i < ensures.length; i++) {
			assertEquals(ensures[i], testFunction.getEnsures()[i]);
		}
		testFunction = new Function(POSITION, new IntegerType(), "testFunction",
				parameters, body, assumptions, ensures);
		testString = "int testFunction(int parameter1, bool parameter2) {\n"
			+"assume (testvar >= 42);\nassume (testvar >= 42);\n"
			+"int testvar = 0;\nint testvar = 0;\nreturn testvar;\n"
			+"ensure (testvar >= 42);\nensure (testvar >= 42);\n"
			+"}";
		assertEquals(testString, testFunction.toString());
		assertEquals(new IntegerType(), testFunction.getReturnType());
	}
	
	@Test
	public void testAssertion() {
		Assertion testAssertion = new Assertion(POSITION, STANDARDCONDITION);
		assertEquals("assert (testvar >= 42);\n", testAssertion.toString());
	}
	
	@Test
	public void testAxiom() {
		Axiom testAxiom = new Axiom(POSITION, STANDARDCONDITION);
		assertEquals("axiom (testvar >= 42);\n", testAxiom.toString());
	}
	
	@Test
	public void testLiterals() {
		BooleanLiteral testBoolean = new BooleanLiteral(POSITION, "true");
		assertEquals("true", testBoolean.toString());
		NumericLiteral testInteger = new NumericLiteral(POSITION, "1");
		assertEquals("1", testInteger.toString());
	}
	
	@Test
	public void testExpression() {
		Multiplication multi = new Multiplication();
		ArithmeticExpression testExpression = new ArithmeticExpression(POSITION, STANDARDEXPRESSION, STANDARDEXPRESSION, multi);
		assertEquals("(testvar * testvar)", testExpression.toString());
		assertEquals(STANDARDEXPRESSION, testExpression.getSubexpression1());
		assertEquals(STANDARDEXPRESSION, testExpression.getSubexpression2());
		assertEquals(multi, testExpression.getArithmeticOperator());
		testExpression = new ArithmeticExpression(POSITION, STANDARDEXPRESSION, STANDARDEXPRESSION, new UnaryMinus());
		assertEquals("(- testvar)", testExpression.toString());
	}
	
	@Test
	public void testAssignment() {
		Assignment testAssignment = new Assignment(POSITION, STANDARDEXPRESSION, new Identifier("var"));
		assertEquals("var = testvar;\n", testAssignment.toString());
		assertEquals(0, testAssignment.getDepth());
		testAssignment.setDepth(1);
		assertEquals(1, testAssignment.getDepth());
		testAssignment.setType(new IntegerType());
		assertEquals(new IntegerType(), testAssignment.getType());
	}
	
	private static final Position POSITION = new Position(0,0);
	private static final Statement STANDARDSTATEMENT = new VariableDeclaration(POSITION, "testvar", new NumericLiteral(new Position(0, 0), "0"), new IntegerType());
	private static final Expression STANDARDEXPRESSION = new VariableRead(POSITION, new Identifier("testvar"));
	private static final LogicalExpression STANDARDCONDITION = new LogicalExpression(POSITION, new VariableRead(POSITION, new Identifier("testvar")), new NumericLiteral(POSITION, "42"), new GreaterEqual());
}
