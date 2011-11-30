package translateglob;

class MatchAllPatternGenerator extends PatternGenerator {
    PatternGenerator next;

    public MatchAllPatternGenerator(PatternGenerator next) {
        this.next = next;
    }

    public String makePattern() {
        return next.makePattern() + ".*";
    }

    public String toString() {
        return next.toString() + '*';
    }
}
