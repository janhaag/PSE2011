package ast;

/**
 * This interface is the prototype for operations on an AST.
 */
public interface ASTVisitor {
    /**
     * Visits a conditional statement.
     * @param conditional conditional to visit
     */
    public void visit(Conditional conditional);
    /**
     * Visits a loop statement.
     * @param loop loop to visit
     */
    public void visit(Loop loop);
    /**
     * Visits an array assignment statement.
     * @param arrayAssignment array assignment to visit
     */
    public void visit(ArrayAssignment arrayAssignment);
    /**
     * Visits an arithmetic expression.
     * @param arithmeticExpression expression to visit
     */
    public void visit(ArithmeticExpression arithmeticExpression);
    /**
     * Visits a numeric literal.
     * @param number literal to visit
     */
    public void visit(NumericLiteral number);
    /**
     * Visits a logical expression.
     * @param logicalExpression expression to visit
     */
    public void visit(LogicalExpression logicalExpression);
    /**
     * Visits a boolean literal.
     * @param bool literal to visit
     */
    public void visit(BooleanLiteral bool);
    /**
     * Visits a function call.
     * @param functionCall function call to visit
     */
    public void visit(FunctionCall functionCall);
    /**
     * Visits a variable read expression.
     * @param variableRead read expression to visit
     */
    public void visit(VariableRead variableRead);
    /**
     * Visits an array read expression.
     * @param arrayRead read expression to visit
     */
    public void visit(ArrayRead arrayRead);
    /**
     * Visits a function.
     * @param function function to visit
     */
    public void visit(Function function);
    /**
     * Visits a program.
     * @param program program to visit
     */
    public void visit(Program program);
    /**
     * Visits an assignment.
     * @param assignment assignment to visit
     */
    public void visit(Assignment assignment);
    /**
     * Visits an assertion.
     * @param assertion assertion to visit
     */
    public void visit(Assertion assertion);
    /**
     * Visits an assumption.
     * @param assumption assumption to visit
     */
    public void visit(Assumption assumption);
    /**
     * Visits an axiom.
     * @param axiom axiom to visit
     */
    public void visit(Axiom axiom);
    /**
     * Visits an ensure statement.
     * @param ensure ensure to visit
     */
    public void visit(Ensure ensure);
    /**
     * Visits an invariant.
     * @param invariant invariant to visit
     */
    public void visit(Invariant invariant);
    /**
     * Visits a return statement.
     * @param returnStatement return statement to visit
     */
    public void visit(ReturnStatement returnStatement);
    /**
     * Visits a variable declaration.
     * @param varDec declaration to visit
     */
    public void visit(VariableDeclaration varDec);
    /**
     * Visits an array declaration.
     * @param arrDec declaration to visit
     */
    public void visit(ArrayDeclaration arrDec);
    /**
     * Visits an exists quantifier.
     * @param existsQuantifier quantifier to visit
     */
    public void visit(ExistsQuantifier existsQuantifier);
    /**
     * Visits a for all quantifier.
     * @param forAllQuantifier quantifier to visit
     */
    public void visit(ForAllQuantifier forAllQuantifier);
    /**
     * Visits a statement block.
     * @param statementBlock statement block to visit
     */
    public void visit(StatementBlock statementBlock);
}
