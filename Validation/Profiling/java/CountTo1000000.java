import java.math.BigInteger;

class CountTo1000000 {
public static void main(String... args) {
    BigInteger i = new BigInteger("0");
    BigInteger max = new BigInteger("1000000");
    while (i.compareTo(max) > 0) {
        i = i.add(new BigInteger("1"));
    }
}
}
