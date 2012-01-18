package interpreter;

import ast.*;

import java.util.*;

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
     * temporarily saves the result of function calls
     */
    private final IdentityHashMap<FunctionCall, Value> returnValues;
    /**
     * function associated with this scope, if there is any
     */
    private final Function currentFunction;
    /**
     * iterator over the statements in the current block
     */
    private final Iterator<Statement> statements;
    /**
     * next statement in this scope
     */
    private Statement currentStatement;
    /**
     * This flag indicates whether variables may searched for in
     * the parent scope. This must be prevented if this scope is
     * associated to a complete function.
     */
    private final boolean variableSearch;

    /**
     * Constructor.
     *
     * @param upScope parent scope of this instance
     * @param currentBlock statement block associated with this scope
     * @param currentFunction function associated with this scope,
     *                        if there is any
     */
    public Scope(Scope upScope, StatementBlock currentBlock,
                 Function currentFunction) {
        this.upScope = upScope;
        this.currentFunction = currentFunction;
        variables = new HashMap<Identifier, Value>();
        returnValues = new IdentityHashMap<FunctionCall, Value>();
        variableSearch = (currentFunction == null) && upScope != null;
        statements = (currentBlock != null)
                     ? currentBlock.getIterator() : null;
    }

    public boolean existsInScope(Identifier identifier) {
        return variables.containsKey(identifier);
    }

    /**
     * Returns the parent scope.
     * @return parent scope
     */
    public Scope getParent() {
        return upScope;
    }

    public boolean isFunctionScope() {
        return currentFunction != null;
    }

    /**
     * Returns the function this scope belongs to.
     *
     * @return function this scope belongs to
     */
    public Function getCurrentFunction() {
        return currentFunction != null
                ? currentFunction : upScope.getCurrentFunction();
    }

    public IdentityHashMap<FunctionCall, Value> getReturnValues() {
        return returnValues;
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
     * @param vars HashMap to which found variables are mapped
     */
    private void addVars(HashMap<Identifier, Value> vars) {
        Set<Identifier> identifiers = variables.keySet();
        for (Identifier identifier : identifiers) {
            if (!vars.containsKey(identifier)) {
                vars.put(identifier, variables.get(identifier));
            }
        }
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
        currentStatement = statements.hasNext() ? statements.next() : null;
        return currentStatement;
    }

    public Statement getCurrentStatement() {
        return currentStatement;
    }

    /**
     * Assigns a new value to a variable.
     * @param name variable name
     * @param value new value (as String)
     */
    public void setVar(String name, String value) {
        Value oldValue = getVariables().get(new Identifier(name));
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

    public void createFunctionResult(FunctionCall functionCall,
                                     Value returnValue) {
        returnValues.put(functionCall, returnValue);
    }

    public void clearFunctionResults() {
        returnValues.clear();
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
