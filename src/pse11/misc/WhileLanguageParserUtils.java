package misc;

import ast.*;
import java.util.LinkedList;


public final class WhileLanguageParserUtils {
    private WhileLanguageParserUtils(){}

    public static LinkedList<Assertion> possibleDivByZero(LinkedList<Expression> expressions) {
        LinkedList<Assertion> result = new LinkedList<Assertion>();
        for (Expression e : expressions) {
            result.add(new Assertion(e.getPosition(),
                new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Invariant> possibleDivByZeroI(LinkedList<Expression> expressions) {
        LinkedList<Invariant> result = new LinkedList<Invariant>();
        for (Expression e : expressions) {
            result.add(new Invariant(e.getPosition(),
                new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Assumption> possibleDivByZeroA(LinkedList<Expression> expressions) {
        LinkedList<Assumption> result = new LinkedList<Assumption>();
        for (Expression e : expressions) {
            result.add(new Assumption(e.getPosition(),
                new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Axiom> possibleDivByZeroAx(LinkedList<Expression> expressions) {
        LinkedList<Axiom> result = new LinkedList<Axiom>();
        for (Expression e : expressions) {
            result.add(new Axiom(e.getPosition(),
                new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Ensure> possibleDivByZeroE(LinkedList<Expression> expressions) {
        LinkedList<Ensure> result = new LinkedList<Ensure>();
        for (Expression e : expressions) {
            result.add(new Ensure(e.getPosition(),
                new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Assertion> possibleArrayOutOfBounds(
            LinkedList<Pair<ArrayRead, Expression>> expressions) {
        LinkedList<Assertion> result = new LinkedList<Assertion>();
        for (Pair<ArrayRead, Expression> p : expressions) {
            Expression e = p.getValue2();
            ArrayRead a = p.getValue1();
            LogicalExpression lower = new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new GreaterEqual());
            LogicalExpression upper = new LogicalExpression(e.getPosition(), e,
                    new FunctionCall(new Identifier("length"), new Expression[] {a},
                        e.getPosition()), new Less());
            result.add(new Assertion(e.getPosition(),
                new LogicalExpression(e.getPosition(), lower, upper, new Conjunction())));
        }
        return result;
    }

    public static LinkedList<Invariant> possibleArrayOutOfBoundsI(
            LinkedList<Pair<ArrayRead, Expression>> expressions) {
        LinkedList<Invariant> result = new LinkedList<Invariant>();
        for (Pair<ArrayRead, Expression> p : expressions) {
            Expression e = p.getValue2();
            ArrayRead a = p.getValue1();
            LogicalExpression lower = new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new GreaterEqual());
            LogicalExpression upper = new LogicalExpression(e.getPosition(), e,
                    new FunctionCall(new Identifier("length"), new Expression[] {a},
                        e.getPosition()), new Less());
            result.add(new Invariant(e.getPosition(),
                new LogicalExpression(e.getPosition(), lower, upper, new Conjunction())));
        }
        return result;
    }

    public static LinkedList<Assumption> possibleArrayOutOfBoundsA(
            LinkedList<Pair<ArrayRead, Expression>> expressions) {
        LinkedList<Assumption> result = new LinkedList<Assumption>();
        for (Pair<ArrayRead, Expression> p : expressions) {
            Expression e = p.getValue2();
            ArrayRead a = p.getValue1();
            LogicalExpression lower = new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new GreaterEqual());
            LogicalExpression upper = new LogicalExpression(e.getPosition(), e,
                    new FunctionCall(new Identifier("length"), new Expression[] {a},
                        e.getPosition()), new Less());
            result.add(new Assumption(e.getPosition(),
                new LogicalExpression(e.getPosition(), lower, upper, new Conjunction())));
        }
        return result;
    }

    public static LinkedList<Axiom> possibleArrayOutOfBoundsAx(
            LinkedList<Pair<ArrayRead, Expression>> expressions) {
        LinkedList<Axiom> result = new LinkedList<Axiom>();
        for (Pair<ArrayRead, Expression> p : expressions) {
            Expression e = p.getValue2();
            ArrayRead a = p.getValue1();
            LogicalExpression lower = new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new GreaterEqual());
            LogicalExpression upper = new LogicalExpression(e.getPosition(), e,
                    new FunctionCall(new Identifier("length"), new Expression[] {a},
                        e.getPosition()), new Less());
            result.add(new Axiom(e.getPosition(),
                new LogicalExpression(e.getPosition(), lower, upper, new Conjunction())));
        }
        return result;
    }

    public static LinkedList<Ensure> possibleArrayOutOfBoundsE(
            LinkedList<Pair<ArrayRead, Expression>> expressions) {
        LinkedList<Ensure> result = new LinkedList<Ensure>();
        for (Pair<ArrayRead, Expression> p : expressions) {
            Expression e = p.getValue2();
            ArrayRead a = p.getValue1();
            LogicalExpression lower = new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new GreaterEqual());
            LogicalExpression upper = new LogicalExpression(e.getPosition(), e,
                    new FunctionCall(new Identifier("length"), new Expression[] {a},
                        e.getPosition()), new Less());
            result.add(new Ensure(e.getPosition(),
                new LogicalExpression(e.getPosition(), lower, upper, new Conjunction())));
        }
        return result;
    }

    public static LinkedList<Assertion> possibleNotPositive(
            LinkedList<Expression> expressions) {
        LinkedList<Assertion> result = new LinkedList<Assertion>();
        if (expressions == null) {
            return result;
        }
        for (Expression p : expressions) {
            result.add(new Assertion(p.getPosition(),
                new LogicalExpression(p.getPosition(), p,
                    new NumericLiteral(p.getPosition(), "0"), new Greater())
                ));
        }
        return result;
    }
}
