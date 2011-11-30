package translateglob;

import java.text.ParseException;

public class Translator {
    int pos;
    PatternGenerator current;
    String globPattern;

    public Translator() {
    }

    public PatternGenerator translate(String globPattern)
      throws ParseException {
        current = new EmptyPatternGenerator();
        pos = 0;
        this.globPattern = globPattern;
        while (pos < globPattern.length()) {
            char c = globPattern.charAt(pos);
            pos++;
            switch (c) {
                case '*':
                    current = new MatchAllPatternGenerator(current);
                    break;
                case '?':
                    current = new MatchOnePatternGenerator(current);
                    break;
                case '[':
                    if (pos == globPattern.length())
                        throw new ParseException(
                            "Non-Terminated Character Class", pos - 1);
                    current = readCharClass(current);
                    pos++;
                    break;
                default:
                    current = new CharPatternGenerator(
                            globPattern.charAt(pos - 1), current);
            }
        }
        return current;
    }

    private PatternGenerator readCharClass(PatternGenerator current)
      throws ParseException{
        boolean negate = false;
        int errpos = pos;
        if (globPattern.charAt(pos) == '!') {
            negate = true;
            pos++;
        }
        int startpos = pos;
        pos++; // class is non-empty
        if (pos == globPattern.length())
            throw new ParseException(
                "Non-Terminated Character Class", errpos);
        while (globPattern.charAt(pos) != ']') {
            if (pos == globPattern.length() - 1)
                throw new ParseException(
                    "Non-Terminated Character Class", errpos);
            pos++;
        }
        return new CharClassPatternGenerator(negate,
                globPattern.substring(startpos, pos),
                current);
    }
}
