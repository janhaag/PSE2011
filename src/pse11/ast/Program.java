package ast;

import interpreter.ASTVisitor;

import java.util.ArrayList;

/**
 *
 */
public class Program extends ASTRoot {
    private ArrayList<Function> functions;
    private Function mainFunction;
    private ArrayList<Axiom> axioms;

    public Program(Position position, ArrayList<Function> functions, Function mainFunction, ArrayList<Axiom> axioms) {
        super(position);
        this.functions = functions;
        this.mainFunction = mainFunction;
        this.axioms = axioms;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public Function getMainFunction() {
        return mainFunction;
    }

    public ArrayList<Axiom> getAxioms() {
        return axioms;
    }
}
