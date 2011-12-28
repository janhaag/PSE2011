package parser;

import ast.*;
import interpreter.ASTVisitor;

/**
 * This class checks the type correctness of a user program.
 */
public class TypeChecker implements ASTVisitor {
    private boolean isMain;
    private Type currentReturnType;
    
    public void checkTypes(ASTRoot ast) throws IllegalTypeException {
        ast.accept(this);
    }
    
    //TODO: fill in stubs
    public void visit(Conditional conditional) {
        conditional.getCondition().accept(this);
        //TODO: new scope
        conditional.getTrueConditionBody().accept(this);
        conditional.getFalseConditionBody().accept(this);
    }

    public void visit(Loop loop) {
        loop.getCondition().accept(this);
        Invariant[] invariants = loop.getInvariants();
        for (Invariant invariant : invariants) {
            invariant.accept(this);
        }
        //TODO: new scope
        loop.getLoopBody().accept(this);
    }

    public void visit(ArrayAssignment arrayAssignment) {
        ArithmeticExpression[] indexes = arrayAssignment.getIndexes();
        for (ArithmeticExpression index : indexes) {
            index.accept(this);
        }
        arrayAssignment.getValue().accept(this);
        //TODO: check types of array and expression
    }

    public void visit(ArithmeticException arithmeticExpression) {
        //TODO: fill in
    }

    public void visit(NumericLiteral number) {
        //no-op
    }

    public void visit(LogicalExpression logicalExpression) {
        //TODO: fill in
    }

    public void visit(BooleanLiteral bool) {
        //no-op
    }

    public void visit(FunctionCall functionCall) {
        //TODO
    }

    public void visit(VariableRead variableRead) {
        //TODO:ensure identifier exists
    }

    public void visit(ArrayRead arrayRead) {
        ArithmeticExpression[] indexes = arrayRead.getIndexes();
        for (ArithmeticExpression index : indexes) {
            index.accept(this);
        }
        //TODO:ensure identifier exists
    }

    public void visit(Function function) {
        currentReturnType = function.getReturnType();
        if (currentReturnType instanceof ArrayType) {
            throw new IllegalTypeException("Functions must not return arrays.",
                                           function.getPosition());
        }
        Assumption[] assumptions = function.getAssumptions();
        for (Assumption assumption : assumptions) {
            assumption.accept(this);
        }
        Ensure[] ensures = function.getEnsures();
        for (Ensure ensure : ensures) {
            ensure.accept(this);
        }
        function.getFunctionBlock().accept(this);
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
        assignment.getValue().accept(this);
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
        ArithmeticExpression[] indexes = arrDec.getIndexes();
        for (ArithmeticExpression index : indexes) {
            index.accept(this);
        }
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
