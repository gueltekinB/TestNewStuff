import java.util.*;

public class CollectionsInfo {

    public static void main(String[] args) {
        List<String> adsd = new LinkedList<>();
        Set<String> aaaaa = new HashSet<>();
        aaaaa.add("sdsad");
        System.out.println(aaaaa);
        adsd.add("sd");
        System.out.println(adsd.get(0));
        testToArrayMethodWithoutParameter();
        testToArrayMethodWithParameter();
    }

    public static void testToArrayMethodWithoutParameter() {
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        values.add("value3");

        Object[] test = values.toArray();
        for (Object o : test) {
            System.out.println(o);
        }

    }

    public static void testToArrayMethodWithParameter() {
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        values.add("value3");

        String[] myString = values.toArray(new String[0]);

        for (String s : myString) {
            System.out.println(s);
        }

    }

    public static void retrievingACollectionFromArray(){
        String[] data = {"data1", "data2", "data3"};


        Collection<String> list = Arrays.asList(data);
        list.forEach(value -> System.out.println(value));
    }

}

