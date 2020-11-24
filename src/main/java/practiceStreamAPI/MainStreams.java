package practiceStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStreams {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);
        Stream<Integer> stream1 = ints.stream();
//                      OR
        Stream<Integer> stream2 = Stream.of(0, 1, 2, 3, 4);

        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
        System.out.println("-----");

        Stream<String> streamOfStrings1 = Stream.generate(() -> "one");
        streamOfStrings1.limit(5).forEach(System.out::println);
        System.out.println("-----");

        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");
        streamOfStrings2.limit(5).forEach(System.out::println);
        System.out.println("-----");

        IntStream streamOfInt = ThreadLocalRandom.current().ints();
        streamOfInt.limit(5).forEach(System.out::println);
        System.out.println("-----");

        Stream<String> stream = Stream.of("A$$$B$$C$".split("\\$"));
        stream.forEach(p -> System.out.println(p));
        System.out.println("-----");

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> streamOfList = list.stream();
        List<Integer> evenNumbersList = streamOfList.filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbersList);
    }
}
