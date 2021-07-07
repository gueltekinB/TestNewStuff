import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NestedClasses {
    private static String test1 = "I am static nested class";
    private static String test3 = "I am static";
    private  String test2 = "I am member nested class";


    // Can access everything with a static context of the outer class.
    private static class StaticNested{
        void staticMethod(){
            System.out.println(test1);
        }
    }

    // Can access everything with a static context and instance context of the outer class.
    public class MemberNested{
        void memberMethod(){
            System.out.println(test2);
            System.out.println(test3);
        }

    }

    //Local inner classes.
    public void localInnerCLassMethod(final String text){
        class LocalInnerClass{
            private void doSomething(){
                System.out.println(text);
            }
        }
        LocalInnerClass s = new LocalInnerClass();
        s.doSomething();
    }

    public static void main(String[] args) {
        // Call static inner class method
        new NestedClasses.StaticNested().staticMethod();

        // member inner class method
        NestedClasses.MemberNested in = new NestedClasses().new MemberNested();
        in.memberMethod();

        NestedClasses as = new NestedClasses();
        as.localInnerCLassMethod("I am a local inner class");

        List<String> testList = List.of("s", "d");
        Integer u = testList.stream()
                .map(s -> s.length())
                .reduce(Integer::sum)
                .get();
        System.out.println(u);
    }

    public static void test(){
        System.out.println("andy");

    }
}
