import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavaMitForEach {
    private List<String> hello;

    public HalloJavaMitForEach(){
        hello = new ArrayList<>();
        hello.add("Hallo Java");
        hello.add("Hello Java");
        hello.add("Hola Java");
        hello.add("Salve Java");
    }

    public void print(){
        for (String s : hello){
            System.out.println(s);
        }

        System.out.println("");

        hello.forEach(s -> System.out.println(s));

        System.out.println("");

        Consumer<String> consumer = (String s) -> System.out.println(s);
        hello.forEach(consumer);

        System.out.println("");

        hello.forEach(System.out::println);
    }
}
