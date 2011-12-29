package interpreter;

import ast.Identifier;
import ast.Statement;
import ast.StatementBlock;
import ast.Type;

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
        variableSearch = isFunctionScope;
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
        //TODO: add vars
        if (variableSearch) {
            upScope.addVars(vars);
        }
    }

    public Statement getNextStatement() {
        return currentBlock.getNextStatement();
    }

    public void setVar(String name, String value) {
        //TODO:
    }

    public void createVar(String name, String value, Type typeOfValue) {

    }
}
