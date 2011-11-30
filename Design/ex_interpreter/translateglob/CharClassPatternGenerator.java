package translateglob;

class CharClassPatternGenerator extends PatternGenerator {
    private String range;
    private boolean negate;
    private PatternGenerator next;

    public CharClassPatternGenerator(boolean negate, String range,
            PatternGenerator next) {
        this.range = range;
        this.negate = negate;
        this.next = next;
    }

    public String makePattern() {
        String neg = negate ? "^" : "";
        return next.makePattern() + '[' + neg + range + ']';
    }

    public String toString() {
        String neg = negate ? "!" : "";
        return next.toString() + '[' + neg + range + ']';
    }
}
