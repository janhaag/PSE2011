package translateglob;

class MatchOnePatternGenerator extends PatternGenerator {
    PatternGenerator next;

    public MatchOnePatternGenerator(PatternGenerator next) {
        this.next = next;
    }

    public String makePattern() {
        return next.makePattern() + '.';
    }

    public String toString() {
        return next.toString() + '?';
    }
}
