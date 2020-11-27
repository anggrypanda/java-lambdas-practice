package Java8Playground;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        assertNotNull(actual);
        assertArrayEquals(new String[]{"TEST1", "TEST2", "TEST3"}, actual.toArray());
    }

    @Test
    @DisplayName("Only words that contain -n- and have 5 chars")
    public void testContainsN() {
        List<String> test = Arrays.asList("ANA12", "ana12", "annna");
        List<String> actual = mainClass.streamContainsN(test);

        assertNotNull(actual);
        assertArrayEquals(new String[]{"ana12", "annna"}, actual.toArray());
    }

    @Test
    @DisplayName("Should return words that start with -n-, uppercased and sorted")
    public void testStartsWithN(){
        List<String> test = Arrays.asList("nana", "name", "number", "attic", "n");
        List<String> actual = mainClass.streamStartsWithN(test);

        assertNotNull(actual);
        assertArrayEquals(new String[] {"N", "NAME", "NANA", "NUMBER"}, actual.toArray());
    }

    @Test
    @DisplayName("{1,62,33} should return (o1,e62,o33)")
    public void testEvenOdd() {
        List<Integer> test = Arrays.asList(1, 62, 33);
        List<String> actual = mainClass.streamEvenOdd(test);

        assertNotNull(actual);
        assertArrayEquals(new String[] {"o1", "e62", "o33"}, actual.toArray());
    }

    @Test
    @DisplayName("Should return: Person Carla, age 49, nationality American")
    public void testOldestPerson() {
        List<Person> test = new ArrayList<Person>();
        test.add(new Person("Alex", 33, "Romanian"));
        test.add(new Person("Carla", 49, "American"));

        Person actual = mainClass.streamOldestPerson(test);
        Person expected = new Person("Carla", 49, "American");

        assertNotNull(actual);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("Should return all persons under 18")
    public void testUnder18() {
        List<Person> test = new ArrayList<Person>();
        test.add(new Person("Marie", 26, "French"));
        test.add(new Person("Ana", 17, "Romanian"));
        test.add(new Person("Andrei", 15, "Romanian"));

        List<Person> actual = mainClass.streamUnder18(test);
        List<Person> expected = new ArrayList<Person>();
        expected.add(new Person("Ana", 17, "Romanian"));
        expected.add(new Person("Andrei", 15, "Romanian"));

        assertNotNull(actual);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("Should return all persons with Romanian nationality, whose name starts with letter “a”, over 18, sorted by age")
    public void testMultipleFilters() {
        List<Person> test = new ArrayList<Person>();
        test.add(new Person("Marie", 26, "French"));
        test.add(new Person("Ana", 17, "Romanian"));
        test.add(new Person("aurel", 52, "Romanian"));
        test.add(new Person("alin", 28, "Romanian"));

        List<Person> actual = mainClass.streamMultipleFilters(test);
        List<Person> expected = new ArrayList<Person>();
        expected.add(new Person("alin", 28, "Romanian"));
        expected.add(new Person("aurel", 52, "Romanian"));

        assertNotNull(actual);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("Should return the unique surnames in uppercase of the first 7 book authors that are 66 years old or older")
    public void testOlderThan66() {
        List<Person> test = new ArrayList<Person>();
        test.add(new Person("Alex", "Age 66", 66, "M"));
        test.add(new Person("Alexandra", "Age 89", 89, "F"));
        test.add(new Person("Marian", "Popescu", 33, "M"));
        test.add(new Person("Ben", "Age 68", 68, "M"));
        test.add(new Person("Valentin", "Age 77", 77, "M"));
        test.add(new Person("Carl", "Popescu", 29, "M"));
        test.add(new Person("Marie", "Popescu", 26, "F"));
        test.add(new Person("Ana", "Popescu", 17, "F"));
        test.add(new Person("alin", "Age 84", 84, "M"));
        test.add(new Person("Andrei", "Age 72", 72, "M"));
        test.add(new Person("Mark", "Age 77", 77, "M"));
        test.add(new Person("Neil", "Age 71", 71, "M"));
        test.add(new Person("Jujo", "Age 24", 24, "F"));

        List<String> actual = mainClass.streamOlderThan66(test);
        List<String> expected = new ArrayList<String>();
        expected.add("AGE 66");
        expected.add("AGE 89");
        expected.add("AGE 68");
        expected.add("AGE 77");
        expected.add("AGE 84");
        expected.add("AGE 72");
        expected.add("AGE 71");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the sum of ages of all female authors younger than 25")
    public void testSumOfAges() {
        List<Person> test = new ArrayList<Person>();
        test.add(new Person("Alex", "Age 66", 66, "M"));
        test.add(new Person("Alexandra", "Age 89", 89, "F"));
        test.add(new Person("Marian", "Popescu", 33, "M"));
        test.add(new Person("Ben", "Age 68", 68, "M"));
        test.add(new Person("Valentin", "Age 77", 77, "M"));
        test.add(new Person("Carl", "Popescu", 29, "M"));
        test.add(new Person("Marie", "Popescu", 26, "F"));
        test.add(new Person("Ana", "Popescu", 17, "F"));
        test.add(new Person("alin", "Age 84", 84, "M"));
        test.add(new Person("Andrei", "Age 72", 72, "M"));
        test.add(new Person("Mark", "Age 77", 77, "M"));
        test.add(new Person("Neil", "Age 71", 71, "M"));
        test.add(new Person("Jujo", "Age 24", 24, "F"));

        Integer actual = mainClass.streamYoungerThan25(test);
        Integer expected = new Integer(41);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}