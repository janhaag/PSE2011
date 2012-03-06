package misc;

import ast.*;
import java.util.LinkedList;


public final class WhileLanguageParserUtils {
    private WhileLanguageParserUtils(){}

    public static LinkedList<Assertion> possibleDivByZero(LinkedList<Expression> expressions) {
        LinkedList<Assertion> result = new LinkedList<Assertion>();
        if (expressions == null) {
            return result;
        }
        for (Expression e : expressions) {
            result.add(new Assertion(e.getPosition(),
                new LogicalExpression(e.getPosition(), e,
                    new NumericLiteral(e.getPosition(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Assertion> possibleArrayOutOfBounds(
            LinkedList<Pair<ArrayRead, Expression>> expressions) {
        LinkedList<Assertion> result = new LinkedList<Assertion>();
        if (expressions == null) {
            return result;
        }
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
