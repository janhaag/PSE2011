package ast;

import interpreter.ASTVisitor;

/**
 * This class symbolizes the user program.
 * The root of the AST is instanceof Program.
 */
public class Program extends ASTRoot {
    /**
     * array of normal functions belonging to the program
     */
    private Function[] functions;
    /**
     * main function of the program
     */
    private Function mainFunction;
    /**
     * global axioms, i.e. formulas given as true
     */
    private Axiom[] axioms;

    /**
     * Constructor.
     *
     * @param position indicates the position of this element
     *                 in the original source code
     * @param functions all functions except 'main'
     * @param mainFunction main function
     * @param axioms global axioms
     */
    public Program(Position position, Function[] functions, Function mainFunction, Axiom[] axioms) {
        super(position);
        this.functions = functions;
        this.mainFunction = mainFunction;
        this.axioms = axioms;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Returns an array of all normal (i.e. all except 'main') functions.
     * @return array of all normal functions
     */
    public Function[] getFunctions() {
        return functions;
    }

    /**
     * Returns the main function.
     * @return main function
     */
    public Function getMainFunction() {
        return mainFunction;
    }

    /**
     * Returns an array of all global axioms.
     * @return global axioms
     */
    public Axiom[] getAxioms() {
        return axioms;
    }
}
