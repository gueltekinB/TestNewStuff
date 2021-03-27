import business.AndroidPhone;
import business.Buttons;
import business.Color;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamAPI {

    public static void main(String[] args) {
        List<Buttons> buttons = new ArrayList<>();
        buttons.add( new Buttons(10,4, Color.RED));
        buttons.add(new Buttons(5,2, Color.BLUE));
        buttons.add(new Buttons(4,5, Color.GREEN));
        AndroidPhone s = new AndroidPhone("S9",232, Color.BLUE,buttons);
        AndroidPhone s1 = new AndroidPhone("S1",100, Color.GREEN, buttons);
        AndroidPhone s2 = new AndroidPhone("S20",333, Color.RED, buttons);
        List<AndroidPhone> andy = new ArrayList<>();
        andy.add(s);
        andy.add(s1);
        andy.add(s2);

        usePredicateInterface(andy);
        useUnaryOperatorInterfaceMap(andy);
        useUnaryOperatorInterfaceFlatMap(andy);
        usePrimitivesInAStream();
        useReduceFunction(andy);
        stringJoinerTest(andy);


    }

    public static void usePredicateInterface(List<AndroidPhone> phones) {
        System.out.println("====== Predicate Result =====");
        List<AndroidPhone> newList = phones.stream()
                .filter(andPhone -> andPhone.getVersionNumber() > 100)
                .peek(s -> System.out.println(s.getVersionNumber()))
                .collect(Collectors.toList());
        System.out.println();
    }

    public static void useUnaryOperatorInterfaceMap(List<AndroidPhone> phones){
        System.out.println("====== UnnarryOperator Result =====");
        List<String> sa = phones.stream()
                .map(s -> s.getModelName())
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println();

    }

    public static void useUnaryOperatorInterfaceFlatMap(List<AndroidPhone> phones){
        System.out.println("====== UnnarryOperator Flatmap Result =====");
        List<Buttons> sa = phones.stream()
                .flatMap(sd -> sd.getButtons().stream())
                .filter(s -> s.getHeight() >= 10)
                .peek(s -> System.out.println(s.getColor()))
                .collect(Collectors.toList());


        System.out.println();

    }

    public static void usePrimitivesInAStream(){
        System.out.println("====== Primitive operator =====");
        int s = IntStream.of(2, 3, 5)
                .filter(value -> value > 2)
                .sum();
        System.out.println(s);

        String[] testArray = {"AREEN", "BLUE","RED"};

        boolean allMatch = Arrays.stream(testArray)
                .allMatch(s1 -> s1.equals("BLUE"));

        boolean anyMatch = Arrays.stream(testArray)
                .anyMatch(s1 -> s1.equals("BLUE"));

        boolean noneMatch = Arrays.stream(testArray)
                .noneMatch(s1 -> s1.equals("BLUE"));

        Optional<String> testMax = Arrays.stream(testArray)
                .min((o1, o2) -> o1.compareTo(o2));

        testMax.ifPresent(System.out::println);

    }

    public static void useReduceFunction(List<AndroidPhone> phones){
        System.out.println("====== Reduce function =====");
        int versionNumber = phones.stream()
                .flatMapToInt(androidPhone -> androidPhone.getButtons().stream().mapToInt(value -> value.getHeight()))
                .reduce(0, (left, right) -> left + right);

        System.out.println(versionNumber);
    }

    public static void stringJoinerTest(List<AndroidPhone> phones){
        System.out.println("====== StringJoiner function =====");


        StringJoiner joinAround = new StringJoiner(",");

        for(AndroidPhone s: phones){
            joinAround.add(s.getModelName());
        }
        System.out.println(joinAround);

        String streamMethod =
                phones.stream()
                .collect(Collectors.mapping(androidPhone -> androidPhone.getModelName(),Collectors.joining(",")));
        System.out.println(streamMethod);

    }
}
