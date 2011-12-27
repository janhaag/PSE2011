package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class Function extends ASTRoot {
    private String name;
    private StatementBlock functionBody;
    private ArrayList<FunctionParameter> parameters;
    private Type returnType;
    
    @Override
    public void accept(ASTVisitor visitor) {
    }

    public Function(Position position, Type returnType, String name, StatementBlock functionBody,
                    ArrayList<FunctionParameter> parameters) {
        super(position);
        this.returnType = returnType;
        this.name = name;
        this.functionBody = functionBody;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public StatementBlock getFunctionBlock() {
        return functionBody;
    }

    public ArrayList<FunctionParameter> getParameters() {
        return parameters;
    }

    public Type getReturnType() {
        return returnType;
    }
}
