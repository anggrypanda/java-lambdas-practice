package Java8Playground;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Function;


public class MainClass {

    public static void main(String[] args) {

//  Given list of string as input. Write a method that will return the list with all the elements in upper case.
        List<String> list1 = Arrays.asList("element1", "eLeMenT2", "ELEMENT3");
        list1 = streamToUpperCase(list1);
        System.out.println(list1);
        System.out.println("-----");

//  Given list of string. Write a method that will return a filtered string list (contains letter ‘n’ and has length 5).
        List<String> list2 = Arrays.asList("ana", "ana12", "abcde");
        list2 = streamContainsN(list2);
        System.out.println(list2);
        System.out.println("-----");

//  Given words list. Write a method that filter words that starts with letter “n”, transform to upper case and sort them.
        List<String> list3 = Arrays.asList("word", "name", "number", "attic", "n");
        list3 = streamStartsWithN(list3);
        System.out.println(list3);
        System.out.println("-----");

//  Given list of integers {1,62,33}. Write a method that will return a comma separated string based on the input.
//  If the number is even, will be preceded by the letter “e”, otherwise “o” (o1,e62,o33).
        List<Integer> list4 = Arrays.asList(1, 62, 33);
        List<String> list4String = streamEvenOdd(list4);

        System.out.println(list4String);
        System.out.println(list4String.toString().replaceAll(" ", ""));
        System.out.println("-----");

//  Given Person objects with name, age, nationality. Write a method that will find the oldest person from a list.
        List<Person> list5 = new ArrayList<Person>();

        list5.add(new Person("Alex", 33, "Romanian"));
        list5.add(new Person("Carl", 39, "American"));
        list5.add(new Person("Marie", 26, "French"));
        list5.add(new Person("Ana", 17, "Romanian"));

        Person listOlder = streamOldestPerson(list5);

        System.out.println(listOlder);
        System.out.println("-----");

//  Given Person objects with name, age, nationality. Write a method that will return all persons under 18.
        List<Person> list6 = new ArrayList<Person>();
        list6.add(new Person("Alex", 33, "Romanian"));
        list6.add(new Person("Carl", 39, "American"));
        list6.add(new Person("Marie", 26, "French"));
        list6.add(new Person("Ana", 17, "Romanian"));
        list6.add(new Person("Andrei", 15, "Romanian"));

        list6 = streamUnder18(list6);
        System.out.println(list6);
        System.out.println("-----");

//  Given Person objects with name, age, nationality. Write a method that filter all persons with Romanian nationality,
//  name start with letter “a”, over 18 and sort them after age.
        List<Person> list7 = new ArrayList<Person>();
        list7.add(new Person("Alex", 33, "Romanian"));
        list7.add(new Person("Carl", 39, "American"));
        list7.add(new Person("Marie", 26, "French"));
        list7.add(new Person("Ana", 17, "Romanian"));
        list7.add(new Person("aurel", 52, "Romanian"));
        list7.add(new Person("alin", 28, "Romanian"));
        list7.add(new Person("Andrei", 41, "Romanian"));

        list7 = streamMultipleFilters(list7);
        System.out.println(list7);
        System.out.println("-----");

//  Library Search
//▪ Get the unique surnames in uppercase of the first 7 book authors that are 66 years old or older.
        List<Person> list8 = new ArrayList<Person>();
        list8.add(new Person("Alex", "Age 66", 66, "M"));
        list8.add(new Person("Alexandra", "Age 89", 89, "F"));
        list8.add(new Person("Marian", "Popescu", 33, "M"));
        list8.add(new Person("Ben", "Age 68", 68, "M"));
        list8.add(new Person("Valentin", "Age 77", 77, "M"));
        list8.add(new Person("Carl", "Popescu", 29, "M"));
        list8.add(new Person("Marie", "Popescu", 26, "F"));
        list8.add(new Person("Ana", "Popescu", 17, "F"));
        list8.add(new Person("alin", "Age 84", 84, "M"));
        list8.add(new Person("Andrei", "Age 72", 72, "M"));
        list8.add(new Person("Mark", "Age 77", 77, "M"));
        list8.add(new Person("Neil", "Age 71", 71, "M"));
        list8.add(new Person("Jujo", "Age 24", 24, "F"));

        List<String> listPerson = streamOlderThan66(list8);
        System.out.println(listPerson);
        System.out.println("-----");

//▪ Print out the sum of ages of all female authors younger than 25
        Integer sumOfAges = streamYoungerThan25(list8);
        System.out.println(sumOfAges);
    }


    public static List<String> streamToUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> streamContainsN(List<String> list) {
        return list.stream()
                .filter(s -> s.contains("n"))
                .filter(s -> s.length() == 5)
                .collect(Collectors.toList());
    }

    public static List<String> streamStartsWithN(List<String> list) {
        return list.stream()
                .filter(s -> s.startsWith("n"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> streamEvenOdd(List<Integer> list) {

        return list.stream()
                .map(i -> {
                    if (i % 2 == 0)
                        return "e" + i;
                    return "o" + i;
                })
                .collect(Collectors.toList());
    }

    public static Person streamOldestPerson(List<Person> list) {
        Person oldest = list.stream()
                .max(Comparator.comparingInt(Person::getAge)).get();
        return oldest;
    }

    public static List<Person> streamUnder18(List<Person> list) {
        return list.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());
    }

    public static List<Person> streamMultipleFilters(List<Person> list) {
        return list.stream()
                .filter(p -> p.getNationality().equals("Romanian"))
                .filter(p -> p.getName().startsWith("a"))
                .filter(p -> p.getAge() > 18)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }

    public static List<String> streamOlderThan66(List<Person> list) {
        return list.stream()
                .filter(p -> p.getAge() >= 66)
                .filter(distinctByKey(p -> p.getSurname()))
                .map(p -> p.getSurname().toUpperCase())
                .limit(7)
                .collect(Collectors.toList());
    }

    public static Integer streamYoungerThan25(List<Person> list) {
        return list.stream()
                .filter(p->p.getSex().equalsIgnoreCase("F"))
                .filter(p->p.getAge() < 25)
                .reduce(0, (sum, p) -> sum += p.getAge(), (sum1, sum2) -> sum1 + sum2);
    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}