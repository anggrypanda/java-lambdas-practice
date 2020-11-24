package practiceCollection;

import java.util.*;

public class MainAPICollectionMap {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 46);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Frank", 18);

        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");

        Map<City, List<Person>> map = new HashMap<>();

        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(p1);
//                  OR
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);


        System.out.println("People from Paris: " + map.getOrDefault(paris, Collections.EMPTY_LIST));
        System.out.println("People from New York: " + map.getOrDefault(newYork, Collections.EMPTY_LIST));
        System.out.println("-----");

        Map<City, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");
        map1.forEach((city, people) -> System.out.println(city + ": " + people));
        System.out.println("-----");


        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);

        System.out.println("Map 2");
        map2.forEach((city, people) -> System.out.println(city + ": " + people));
        System.out.println("-----");

        map2.forEach(                                                   // looping through all the key, value pairs of map2
                (city, people) -> {                                     // BiConsumer
                    map1.merge (                                        // merging map1 with map2
                            city, people,                               // key, value that will be added to map1
                            (peopleFromMap1, peopleFromMap2) -> {       // existing people (already associated with map1), new people
                            peopleFromMap1.addAll(peopleFromMap2);      // creating the new list by adding all the new people
                            return peopleFromMap1;                      // returning the new merged list
                            });
                }
        );

        System.out.println("Merged map1");
        map1.forEach(
                ((city, people) -> System.out.println(city + ": " + people))
        );

    }
}