package parser;

import ast.*;
import interpreter.ASTVisitor;

/**
 * This class checks the type correctness of a user program.
 */
public class TypeChecker implements ASTVisitor {
    private boolean isMain;
    
    public void checkTypes(ASTRoot ast) throws IllegalTypeException {
        ast.accept(this);
    }
    
    //TODO: fill in stubs
    public void visit(Conditional conditional) {
    }

    public void visit(Loop loop) {
    }

    public void visit(ArrayAssignment arrayAssignment) {
    }

    public void visit(ArithmeticException arithmeticExpression) {
    }

    public void visit(NumericLiteral number) {
        //no-op
    }

    public void visit(LogicalExpression logicalExpression) {

    }

    public void visit(BooleanLiteral bool) {
        //no-op
    }

    public void visit(FunctionCall functionCall) {
    }

    public void visit(VariableRead variableRead) {
    }

    public void visit(ArrayRead arrayRead) {
    }

    public void visit(Function function) {
    }

    public void visit(Program program) {
        Function[] functions = program.getFunctions();
        isMain = false;
        for (Function function : functions) {
            function.accept(this);
        }
        isMain = true;
        program.getMainFunction().accept(this);
    }

    public void visit(Assignment assignment) {
    }

    public void visit(Assertion assertion) {
        assertion.getExpression().accept(this);
    }

    public void visit(Assumption assumption) {
        assumption.getExpression().accept(this);
    }

    public void visit(Axiom axiom) {
        axiom.getExpression().accept(this);
    }

    public void visit(Ensure ensure) {
        ensure.getExpression().accept(this);
    }

    public void visit(Invariant invariant) {
        invariant.getExpression().accept(this);
    }

    public void visit(ReturnStatement returnStatement) {
    }

    public void visit(VariableDeclaration varDec) {
    }

    public void visit(ArrayDeclaration arrDec) {
    }

    public void visit(ExistsQuantifier existsQuantifier) {
    }

    public void visit(ForAllQuantifier forAllQuantifier) {
    }

    public void visit(StatementBlock statementBlock) {
        Statement currentStatement = statementBlock.getNextStatement();
        while (currentStatement != null) {
            currentStatement.accept(this);
            currentStatement = statementBlock.getNextStatement();
        }
    }

    public void visit(Length length) {
    }
}
