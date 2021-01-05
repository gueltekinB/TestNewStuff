import java.util.*;
import java.util.regex.Pattern;

public class StringJoiners {

    public static void main(String[] args) {
        test1();
        System.out.println(stringFormat());
        System.out.println(stringJoiner("alpha", "beta", "gamma").toString());
    }

    private static StringJoiner stringJoiner(String text1, String text2, String text3){
        // afterEachWord
        CharSequence charSequence = "], [";
        // inFrontOfEachWord
        CharSequence prefix = "[";
        // endOfEachWord
        CharSequence suffix = "]";
        StringJoiner stringJoiner = new StringJoiner(charSequence, prefix, suffix);
        return stringJoiner.add(text1).add(text2).add(text3);
    }

    // the precentage is the format specifier start and follwed by the conversion to decide how to show the value and if there is a . then this is a precision.
    private static String stringFormat(){
        int zahl1 = 1222;
        int zahl2 = 2;
        int zahl3 = 3;
        int longNumber = 123456789;
        double dif = zahl3 / 5f;
        System.out.println(String.format("This number is formted to eine stelle hinterm komma %.1f", dif));
        // width and flags the 0 makes all the zeros in front of the 3 and the 3 is the with of the number
        System.out.println(String.format("Test %03d", zahl1));
        // format flag = ","
        System.out.println(String.format("This numbner will get formated with commas %,d", longNumber));
        return String.format("This is a test %d this is a number %d and this %d", zahl1,zahl2,zahl3);

    }

    private static void test1(){
        String test = "apple,  apple and orange please";
        String[] parts = test.split("\\b");

        for(String match : parts){
            if(match.matches("\\w+")){
                System.out.println(match);
            }
        }

    }
}
