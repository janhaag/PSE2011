package verifier;

import ast.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class SMTLibTranslator implements ASTVisitor {
    private ArrayList<LinkedList<S_Expression>> programs;
    private S_Expression tempExpr;

    public WPProgram getWPTree(ASTRoot ast) {
        //TODO: Fill stub
        programs = new ArrayList<LinkedList<S_Expression>>();
        return null;
    }

    //TODO: fill in stubs
    @Override
    public void visit(Conditional conditional) {
    }

    @Override
    public void visit(Loop loop) {
    }

    @Override
    public void visit(ArrayAssignment arrayAssignment) {
    }

    @Override
    public void visit(ArithmeticExpression arithmeticExpression) {
    }

    @Override
    public void visit(NumericLiteral number) {
        tempExpr = new Constant(number.toString());
    }

    @Override
    public void visit(LogicalExpression logicalExpression) {
    }

    @Override
    public void visit(BooleanLiteral bool) {
        tempExpr = new Constant(bool.toString());
    }

    @Override
    public void visit(FunctionCall functionCall) {
    }

    @Override
    public void visit(VariableRead variableRead) {
        tempExpr = new Variable(variableRead.toString());
    }

    @Override
    public void visit(ArrayRead arrayRead) {
    }

    @Override
    public void visit(Function function) {
        programs.add(new LinkedList<S_Expression>());
        LinkedList<S_Expression> program = programs.get(0);
        program.add(new Constant("true"));
        Ensure[] ensures = function.getEnsures();
        for (Ensure ensure : ensures) {
            ensure.accept(this);
            program.set(program.size() - 1, new S_Expression("and",
                            new S_Expression[]{tempExpr, program.getLast()}));
        }
        function.getFunctionBlock().accept(this);
    }

    @Override
    public void visit(Program program) {
    }

    @Override
    public void visit(Assignment assignment) {
    }

    @Override
    public void visit(Assertion assertion) {
    }

    @Override
    public void visit(Assumption assumption) {
    }

    @Override
    public void visit(Axiom axiom) {
    }

    @Override
    public void visit(Ensure ensure) {
        ensure.getExpression().accept(this);
    }

    @Override
    public void visit(Invariant invariant) {
    }

    @Override
    public void visit(ReturnStatement returnStatement) {
    }

    @Override
    public void visit(VariableDeclaration varDec) {
    }

    @Override
    public void visit(ArrayDeclaration arrDec) {
    }

    @Override
    public void visit(ExistsQuantifier existsQuantifier) {
    }

    @Override
    public void visit(ForAllQuantifier forAllQuantifier) {
    }

    @Override
    public void visit(StatementBlock statementBlock) {
    }
}
