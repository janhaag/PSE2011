package misc;

import ast.*;
import java.util.LinkedList;


public final class WhileLanguageParserUtils {
    private WhileLanguageParserUtils(){}

    public static LinkedList<Assertion> possibleDivByZero(LinkedList<Expression> expressions) {
        LinkedList<Assertion> result = new LinkedList<Assertion>();
        for (Expression e : expressions) {
            result.add(new Assertion(new Position(),
                new LogicalExpression(new Position(), e, new NumericLiteral(new Position(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Invariant> possibleDivByZeroI(LinkedList<Expression> expressions) {
        LinkedList<Invariant> result = new LinkedList<Invariant>();
        for (Expression e : expressions) {
            result.add(new Invariant(new Position(),
                new LogicalExpression(new Position(), e, new NumericLiteral(new Position(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Assumption> possibleDivByZeroA(LinkedList<Expression> expressions) {
        LinkedList<Assumption> result = new LinkedList<Assumption>();
        for (Expression e : expressions) {
            result.add(new Assumption(new Position(),
                new LogicalExpression(new Position(), e, new NumericLiteral(new Position(), "0"), new NotEqual())
                ));
        }
        return result;
    }

    public static LinkedList<Ensure> possibleDivByZeroE(LinkedList<Expression> expressions) {
        LinkedList<Ensure> result = new LinkedList<Ensure>();
        for (Expression e : expressions) {
            result.add(new Ensure(new Position(),
                new LogicalExpression(new Position(), e, new NumericLiteral(new Position(), "0"), new NotEqual())
                ));
        }
        return result;
    }
}
