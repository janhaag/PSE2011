package misc;

public class Pair<V, W> {
    /**
     * The first value.
     */
    private V v;

    /**
     * The second value.
     */
    private W w;

    /**
     * Constructor.
     * @param value1 the first value
     * @param value2 the second value
     */
    public Pair(V value1, W value2) {
        v = value1;
        w = value2;
    }

    /**
     * Get the first value.
     * @return the first value
     */
    public V getValue1 {
        return v;
    }

    /**
     * Get the second value.
     * @return the second value
     */
    public W getValue2() {
        return w;
    }
}
