import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DemoTest {
    @Test
    public void compare_two_number() {
        final int expected = 2;
        final int equivalent = 2;
        assertEquals(expected, equivalent);
    }

    @Test
    public void comparing_two_object_values() {
        final String expected = "Hello";
        final String equivalent = "Hello";
        assertEquals(expected, equivalent);
    }

    @Test
    public void comparing_if_two_objects_are_the_same_one() {
        final Object expected = new Object();
        final Object actual = expected;
        assertSame(expected, actual);
    }

    @Test
    public void comparing_elements_in_two_arrays() {
        final String[] expected = new String[] { "one", "two", "three" };
        final String[] equivalent = new String[] { "one", "two", "three" };
        assertArrayEquals(expected, equivalent);
    }

    @Test
    public void comparing_elements_in_two_iterables() {
        final List<String> expected = new ArrayList<>();
        expected.add("one");
        expected.add("two");
        final List<String> actual = Arrays.asList("one", "two");
        assertIterableEquals(expected, actual);
    }

    @Test
    public void assert_statements_will_throw_an_exception() {
        assertThrows(NullPointerException.class, () -> ((String)null).length());
    }

}
