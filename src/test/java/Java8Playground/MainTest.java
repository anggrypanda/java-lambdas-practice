package Java8Playground;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    MainClass mainClass = new MainClass();

    @Test
    @DisplayName("-test- should be -TEST- after UpperCase")
    public void testToUpperCase() {
        List<String> test = Arrays.asList("test1", "tEsT2", "TEST3");
        List<String> actual = mainClass.streamToUpperCase(test);

        assertArrayEquals(new String[]{"TEST1", "TEST2", "TEST3"}, actual.toArray());
    }

    @Test
    @DisplayName("Only words that contain -n- and have 5 chars")
    public void testContainsN() {
        List<String> test = Arrays.asList("ANA12", "ana12", "annna");
        List<String> actual = mainClass.streamContainsN(test);

        assertArrayEquals(new String[]{"ana12", "annna"}, actual.toArray());
    }

    @Test
    @DisplayName("Should return words that start with -n-, uppercased and sorted")
    public void testStartsWithN(){
        List<String> test = Arrays.asList("nana", "name", "number", "attic", "n");
        List<String> actual = mainClass.streamStartsWithN(test);

        assertArrayEquals(new String[] {"N", "NAME", "NANA", "NUMBER"}, actual.toArray());
    }

    @Test
    @DisplayName("{1,62,33} should return (o1,e62,o33)")
    public void testEvenOdd() {
        List<Integer> test = Arrays.asList(1, 62, 33);
        List<String> actual = mainClass.streamEvenOdd(test);

        assertArrayEquals(new String[] {"o1", "e62", "o33"}, actual.toArray());
    }

//    @Test
//    @DisplayName("Should return: Person Carla, age 49, nationality American);")
//    public void testOldestPerson() {
//        List<Person> test = new ArrayList<Person>();
//        test.add(new Person("Alex", 33, "Romanian"));
//        test.add(new Person("Carla", 49, "American"));
//        Person actual = mainClass.streamOldestPerson(test);
//
//        assertArrayEquals(new Person("Carla", 49, "American"), actual));
//    }

}
