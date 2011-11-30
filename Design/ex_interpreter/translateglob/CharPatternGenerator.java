package translateglob;

import static java.util.Arrays.binarySearch;

class CharPatternGenerator extends PatternGenerator {
    private String pattern;
    private PatternGenerator next;
    private static char[] REGEX_CHARS = new char[] {
        '$', '(', ')', '+', '.', '\\', ']', '^', '{', '|', '}', };

    public CharPatternGenerator(char pattern, PatternGenerator next) {
        if (binarySearch(REGEX_CHARS, pattern) >= 0)
            this.pattern = "\\" + pattern;
        else
            this.pattern = "" + pattern;
        this.next = next;
    }

    public String makePattern() {
        return next.makePattern() + pattern;
    }

    public String toString() {
        return next.toString() + pattern.charAt(pattern.length() - 1);
    }
}
