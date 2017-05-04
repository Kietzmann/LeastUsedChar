package wix.kytsmen.java;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;
import static wix.kytsmen.java.CharUtils.leastUsedChar;
//import static wix.kytsmen.java.CharUtils.leastUsedCharWithLeastComplexity;

@RunWith(Parameterized.class)
public class CharUtilsTest {
    private final String input;
    private final char expected;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public CharUtilsTest(String input, char expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"aaabbc", 'c'},
                {"aaabbaab", 'b'},
                {"aabbaabb", 'a'},
        });
    }


    // Do not run this) for such small input it will run for a very long time
    @Test
    public void leastUsedCharShouldReturnMostLeastUsedCharInPassedString() {
        assertEquals(expected, leastUsedChar(input));
    }

    @Test
    public void leastUsedCharShouldThrowIllegalArgumentExceptionIfStringIsNull() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(is("String is null!"));
        String string = null;
        leastUsedChar(string);
    }

    @Test
    public void leastUsedCharShouldThrowIllegalArgumentExceptionIfStringIsEmpty() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(is("String is empty!"));
        String string = "";
        leastUsedChar(string);
    }

    //This is more acceptable but don't fit to task requirements(
//    @Test
//    public void leastUsedCharWithLeastComplexityShouldReturnMostLeastUsedCharInPassedString() {
//        assertEquals(expected, leastUsedCharWithLeastComplexity(input));
//    }
}
