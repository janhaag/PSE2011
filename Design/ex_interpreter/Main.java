import translateglob.*;
import java.text.ParseException;

public class Main {
    public static void main(String... args) {
        if (args.length != 1) {
            System.out.println("Usage: Main pattern");
            System.exit(1);
        }
        Translator t = new Translator();
        PatternGenerator p;
        try {
            p = t.translate(args[0]);
            System.out.println(p);
            System.out.println(p.makePattern());
        } catch (ParseException e) {
            System.out.print("At position " + e.getErrorOffset() + ": ");
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }
}
