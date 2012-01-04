package interpreter;

import ast.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a scope in a user program,
 * i.e. a domain of visibility for variables.
 * A scope may have a parent scope which surrounds it.
 * A variable not available in the scope is searched for
 * in the parent scope.
 * Variables in this scope hide variables in the parent
 * scope that have the same name.
 */
public class Scope {
    /**
     * parent scope of this instance
     */
    private final Scope upScope;
    /**
     * list of all variables mapped to their current value
     */
    private final HashMap<Identifier, Value> variables;
    /**
     * statement block associated with this scope
     */
    private final StatementBlock currentBlock;
    /**
     * This flag indicates whether variables may searched for in
     * the parent scope. This must be prevented if this scope is
     * associated toa complete function.
     */
    private final boolean variableSearch;

    /**
     * Constructor.
     *
     * @param upScope parent scope of this instance
     * @param currentBlock statement block associated with this scope
     * @param isFunctionScope indicates whether this scope belongs to
     *                        a function or not
     */
    public Scope(Scope upScope, StatementBlock currentBlock,
                 boolean isFunctionScope) {
        this.upScope = upScope;
        this.currentBlock = currentBlock;
        variables = new HashMap<Identifier, Value>();
        variableSearch = !isFunctionScope && upScope != null;
    }

    /**
     * Returns the parent scope.
     * @return parent scope
     */
    public Scope getParent() {
        return upScope;
    }

    /**
     * Returns a list of all values that are currently mapped to
     * variables in this or - if not hidden - the parent scopes.
     * @return list of all values mapped to variables in this (or parent) scope
     */
    public HashMap<Identifier, Value> getVariables() {
        HashMap<Identifier, Value> vars = new HashMap<Identifier, Value>();
        addVars(vars);
        return vars;
    }

    /**
     * Adds all non-shadowed variables to parameter vars and searches
     * the parent scope for more (if variableSearch is true).
     * @param vars
     */
    private void addVars(HashMap<Identifier, Value> vars) {
        vars.putAll(variables);
        if (variableSearch) {
            upScope.addVars(vars);
        }
    }

    /**
     * Returns the statement followed by the current statement
     * or null if the block was traversed completely.
     * @return next statement
     */
    public Statement getNextStatement() {
        return currentBlock.getNextStatement();
    }

    /**
     * Assigns a new value to a variable.
     * @param name variable name
     * @param value new value (as String)
     */
    public void setVar(String name, String value) {
        Value oldValue = variables.get(new Identifier(name));
        if (oldValue instanceof BooleanValue) {
            ((BooleanValue) oldValue).setValue(value);
        } else {
            ((IntegerValue) oldValue).setValue(value);
        }
    }

    /**
     * Assigns a new value to an element in an array.
     * @param name array name
     * @param value new value (as String)
     * @param indexes indexes describing the position of the
     *                element that will be changed
     */
    public void setArray(String name, String value,
                         ArrayList<Integer> indexes) {
        Value array = variables.get(new Identifier(name));
        if (array instanceof ArrayValue) {
            ((ArrayValue) array).setValue(value, indexes);
        }
    }

    /**
     * Creates a new variable with the specified name and type.
     * @param name variable name
     * @param value initial value of this variable (as String)
     * @param typeOfValue type of the new variable
     */
    public void createVar(String name, String value, Type typeOfValue) {
        Identifier identifier = new Identifier(name);
        Value newValue;
        if (typeOfValue instanceof BooleanType) {
            newValue = new BooleanValue(value);
        } else {
            newValue = new IntegerValue(value);
        }
        variables.put(identifier, newValue);
    }

    /**
     * Creates an array with the specified name, lengths and type.
     * @param name array name
     * @param typeOfValue type of the array to be created
     * @param lengths lengths of the different array dimensions
     */
    public void createArray(String name, Type typeOfValue, int[] lengths) {
        Identifier identifier = new Identifier(name);
        Value newValue = new ArrayValue((ArrayType) typeOfValue, lengths, 0);
        variables.put(identifier, newValue);
    }
}
