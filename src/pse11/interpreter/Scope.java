package interpreter;

import ast.*;

import java.util.HashMap;

/**
 *
 */
public class Scope {
    private Scope upScope;
    private HashMap<Identifier, Value> variables;
    private StatementBlock currentBlock;
    private boolean variableSearch;

    public Scope(Scope upScope, StatementBlock currentBlock,
                 boolean isFunctionScope) {
        this.upScope = upScope;
        this.currentBlock = currentBlock;
        variables = new HashMap<Identifier, Value>();
        variableSearch = !isFunctionScope && upScope == null;
    }

    public Scope getParent() {
        return upScope;
    }

    public HashMap<Identifier, Value> getVariables() {
        HashMap<Identifier, Value> vars = new HashMap<Identifier, Value>();
        addVars(vars);
        return vars;
    }

    private void addVars(HashMap<Identifier, Value> vars) {
        vars.putAll(variables);
        if (variableSearch) {
            upScope.addVars(vars);
        }
    }

    public Statement getNextStatement() {
        return currentBlock.getNextStatement();
    }

    public void setVar(String name, String value) {
        //TODO: fill stub (not needed for type checker
    }

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

    public void createArray(String name, Type typeOfValue, int[] lengths) {
        Identifier identifier = new Identifier(name);
        Value newValue = new ArrayValue((ArrayType) typeOfValue, lengths, 0);
        variables.put(identifier, newValue);
    }
}
