package interpreter;

import ast.*;
import parser.IllegalTypeException;
import parser.TypeChecker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class encapsulates the context of a program execution.
 */
public class ProgramExecution {
    /**
     * state the program currently is in
     */
    private final State currentState;
    /**
     * list of this program's statement breakpoints
     */
    private ArrayList<StatementBreakpoint> statementBreakpoints;
    /**
     * list of this program's global breakpoints
     */
    private ArrayList<GlobalBreakpoint> globalBreakpoints;
    
    //TODO: delete typeChecker if necessary
    /**
     * type checker to evaluate the type correctness of global statements
     */
    private final TypeChecker typeChecker;
    /**
     * interpreter to evaluate breakpoint expressions 
     */
    private final Interpreter interpreter;

    /**
     * Constructor.
     * 
     * @param ast program whose execution context is saved
     * @param interpreter interpreter to evaluate breakpoint expressions
     */
    public ProgramExecution(ASTRoot ast, Interpreter interpreter, ArrayList<StatementBreakpoint> sbreakpoints,
    		ArrayList<GlobalBreakpoint> gbreakpoints, String[] parameterValues) {
        this.statementBreakpoints = sbreakpoints;
        this.globalBreakpoints = gbreakpoints;
        currentState = new State(ast);
        typeChecker = new TypeChecker();
        this.interpreter = interpreter;
        initParams(parameterValues);
    }

    private void initParams(String[] values) {
        FunctionParameter[] parameters = currentState.getCurrentFunction().getParameters();
        if (values == null)return;
        for (int i = 0; i < values.length; i++) {
            if (parameters[i].getType() instanceof ArrayType) {
                initArray(parameters[i], values[i]);
            } else {
                currentState.createVar(parameters[i].getName(),
                        values[i], parameters[i].getType());
            }
        }
    }

    public void initArray(FunctionParameter parameter, String value) {
    	Type type = parameter.getType();
        int depth = 0;
        while (type instanceof ArrayType) {
            type = ((ArrayType) type).getType();
            depth += 1;
        }
        int[] maxIndex = new int[depth + 1];
        int[] counters = new int[depth + 1];
        depth = 0;
        boolean valid = true;
        for (int i = 0; (i < value.length()) && valid; i++) {
            char c = value.charAt(i);
            if (c == '{') {
                if (depth < maxIndex.length) {
                    depth += 1;
                    counters[depth] = 1;
                } else {
                    valid = false;
                }
            }
            if (c == ',') {
                counters[depth] += 1;
            }
            if (c == '}') {
                if (depth > 0) {
                    if (counters[depth] > maxIndex[depth]) {
                        maxIndex[depth] = counters[depth];
                    }
                    depth -= 1;
                } else {
                    valid = false;
                }
            }
        }
        currentState.createArray(parameter.getName(), parameter.getType(),
                maxIndex);
    }

    public boolean checkBreakpoints() {
        for (StatementBreakpoint statementBreakpoint : statementBreakpoints) {
            if ((currentState.getCurrentStatement().getPosition().getLine()
                            == statementBreakpoint.getLine())
                    && statementBreakpoint.isActive()) {
                return true;
            }
        }
        for (GlobalBreakpoint globalBreakpoint : globalBreakpoints) {
            if (globalBreakpoint.isActive()) {
                typeChecker.setCurrentScope(currentState.getCurrentScope());
                try {
                    Expression condition = globalBreakpoint.getExpression();
                    Assertion assertion = new Assertion(new Position(), condition);
                    typeChecker.setFunctionCallAllowed(false);
                    assertion.accept(typeChecker);
                    typeChecker.setFunctionCallAllowed(true);
                    assertion.accept(interpreter);
                    return true;
                } catch (IllegalTypeException ignored) {
                } catch (AssertionFailureException ignored) {
                }
            }
        }
        return false;
    }

    public State getCurrentState() {
        return currentState;
    }

    public ArrayList<StatementBreakpoint> getStatementBreakpoints() {
        return statementBreakpoints;
    }

    public ArrayList<GlobalBreakpoint> getGlobalBreakpoints() {
        return globalBreakpoints;
    }

    public void setStatementBreakpoints(
            ArrayList<StatementBreakpoint> statementBreakpoints) {
        this.statementBreakpoints = statementBreakpoints;
    }

    public void setGlobalBreakpoints(
            ArrayList<GlobalBreakpoint> globalBreakpoints) {
        this.globalBreakpoints = globalBreakpoints;
    }
    
    public HashMap<Identifier, Value> getVariables() {
        return currentState.getVariables();
        //TODO: delete this and comment out the line above
        /*HashMap<Identifier, Value> vars = new HashMap<Identifier, Value>();
        ArrayValue a = new ArrayValue(new ArrayType(new BooleanType()),
                                      new int[]{2}, 0);
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(0);
        a.setValue("true", l);
        vars.put(new Identifier("a"), a);
        vars.put(new Identifier("B"), new BooleanValue("true"));
        vars.put(new Identifier("z_k"), new IntegerValue("-8"));
        ArrayValue i =
                new ArrayValue(new ArrayType(new ArrayType(new IntegerType())),
                                      new int[]{2, 1}, 0);
        l.add(1);l.add(0);
        i.setValue("42", l);
        vars.put(new Identifier("i0"), i);
        return vars; */
    }
}
