package interpreter;

import ast.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * This class encapsulates a state during program execution.
 * It contains the current scope
 * (which saves the variables and all other scopes)
 * and the reference to the statement that will be executed.
 */
public class State implements Cloneable {
    /**
     * current scope during program execution
     */
    private Scope currentScope;
    /**
     * statement that will be executed next
     */
    private Statement currentStatement;

    /**
     * Constructor.
     *
     * @param ast program that is executed
     */
    public State(ASTRoot ast) {
        if (!(ast instanceof Program)) {
            throw new IllegalArgumentException("AST must be a program!");
        }
        Function main = ((Program) ast).getMainFunction();
        /*TODO: erase following line if it is clear what to do at the beginning
        of a program*/
        currentScope = new Scope(null, main.getFunctionBlock(), main);
        adjustStatement();
    }

    /**
     * Destroys the currently most inner scope.
     */
    public void destroyScope() {
        currentScope = currentScope.getParent();
        if (currentScope != null) {
            currentStatement = currentScope.getCurrentStatement();
        }
    }

    /**
     * Creates a new scope with the given parameters. The old scope
     * will become parent scope of this new one.
     * @param statementBlock statement block belonging to this scope
     * @param currentFunction function associated with this scope,
     *                        if there is any
     */
    public void createScope(StatementBlock statementBlock,
                            Function currentFunction) {
        currentScope = new Scope(currentScope, statementBlock, currentFunction);
    }

    /**
     * Changes the value of a variable.
     * @param name name of the variable that should be changed
     * @param value new value (as String)
     */
    public void setVar(String name, String value) {
        currentScope.setVar(name, value);
    }

    /**
     * Changes the value of an array element.
     * @param name name of the array that contains the element
     * @param value new value (as String)
     * @param indexes position of this element
     */
    public void setArray(String name, String value,
                         ArrayList<Integer> indexes) {
        currentScope.setArray(name, value, indexes);
    }

    /**
     * Creates a new variable with the given values.
     * @param name name of the new variable
     * @param value initial value (as String)
     * @param typeOfValue type of the variable
     */
    public void createVar(String name, String value, Type typeOfValue) {
        currentScope.createVar(name, value, typeOfValue);
    }

    /**
     * Creates a new array and initializes all its elements to the
     * default value that is specified within the base type of the array.
     * @param name name of the new array
     * @param typeOfValue type of the new array
     * @param lengths length of the different array dimensions
     */
    public void createArray(String name, Type typeOfValue, int[] lengths) {
        currentScope.createArray(name, typeOfValue, lengths);
    }

    /**
     * Returns a map of all variables and their values
     * that are saved within the current scope.
     * @return map of all saved variables and their values
     */
    public HashMap<Identifier, Value> getVariables() {
        return currentScope.getVariables();
    }

    /**
     * Returns the current scope.
     * @return current scope
     */
    public Scope getCurrentScope() {
        return currentScope;
    }

    /**
     * Returns the current statement.
     * @return current statement
     */
    public Statement getCurrentStatement() {
        return currentStatement;
    }

    /**
     * Sets the current statement reference to the next statement;
     * destroys the current scope if it is evaluated completely and
     * not a function scope.
     */
    public void adjustStatement() {
        currentScope.clearFunctionResults();
        currentStatement = currentScope.getNextStatement();
    }

    /**
     * Returns the function associated with the current scope.
     * Returns null if this scope is not a function's scope.
     * @return function associated with the current scope
     */
    public Function getCurrentFunction() {
        return currentScope.getCurrentFunction();
    }

    public boolean isFunctionScope() {
        return currentScope.isFunctionScope();
    }

    public IdentityHashMap<FunctionCall, Value> getReturnValues() {
        return currentScope.getReturnValues();
    }

    public void createFunctionResult(FunctionCall functionCall,
                                     Value returnValue) {
        currentScope.createFunctionResult(functionCall, returnValue);
    }
}