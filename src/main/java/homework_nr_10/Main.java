package homework_nr_10;

import java.util.regex.*;
import java.util.*;
public class Main {
    static void getTheTasks (List<String> input){
        input.forEach((e) -> System.out.println(input.indexOf(e) + " - " + e));
    }
    static void getUnic(List<String> input) {
        HashSet<String> unic = new HashSet<>(input);
        System.out.println(unic);
    }
    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();
        tasks.add("A Make the food");
        tasks.add("Make the food al");
        tasks.add("Make the food ");
        tasks.add("Wash the dishes");
        tasks.add("Wash al the dishes");
        tasks.add("Go to work");
        tasks.add("Make homework_nr_10");
        tasks.add("Learn Java");
        getTheTasks(tasks);

        List<String> strings = new ArrayList<>();
        String hello = "hello";
        for (int index = 0; index != hello.length(); index ++) {
            char letter = hello.charAt(index);
            String str = String.valueOf(letter);
            strings.add(str);
        }
        getUnic(strings);

        Map<String, String> engRom = new HashMap<>();
        engRom.put("Cat", "Pisica");
        engRom.put("Dog", "Caine");
        engRom.put("Cow", "Vaca");
        engRom.put("Bear", "Ursulikэ");
        engRom.put("Beer", "Bere");
        System.out.println(engRom);

        Deque<String> lifoString = new ArrayDeque<>();
        lifoString.add("First");
        lifoString.add("Second");
        lifoString.add("Third");
        lifoString.add("Fourth");
        lifoString.add("Fifth");
        for(int index = 0; index < 3; index++)
            System.out.println(lifoString.removeLast());
        System.out.println("\n" + lifoString.getLast());
        System.out.println("\n" + lifoString.getFirst());

        tasks.removeIf(e -> e.startsWith("A"));
        System.out.println(tasks);

        tasks.replaceAll((e) -> {
            if (Pattern.matches(".*al.*", e))
                return "replaced String";
            else return e;
        });
        System.out.println(tasks);
    }
}
