package pl.primenumbers;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class PrimeNumbersTest {

    @Test
    private void shouldCreateTableWithValuesMarkedAsPrimeNumbers() {

        int x = 3;
        int[][] expResult = {{2,1}, {3,1}, {4,1}};

        int[][] result = new PrimeNumbers().createTable(x);

        assertEquals(result, expResult);
    }

    @Test
    private void shouldMarkAllNumbersAsNonPrimeDespiteFirstPairInArray() {

        int range = 2;
        int[][] numbersTable = {{2,1}, {3,1}, {4,1}, {5,1}};
        int[][] expResult = {{2,1}, {3,0}, {4,0}, {5,0}};

        PrimeNumbers instance = new PrimeNumbers(new CommonOperations() {
            boolean isDivisible(int divident, int divisor) {
                return true;
            }
        });

        int[][] result = instance.markNonPrimeFromTable(numbersTable, range);

        assertEquals(result, expResult);
    }

    @Test
    private void shouldDisplayInConsoleOnlyPrimeNumbers() {

        int[][] numbersTable = {{2, 1}, {3, 0}, {5, 1}, {7, 1}, {11, 0}};
        String expectedResult = "|2|5|7";

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));

        new PrimeNumbers().showPrimeNumbers(numbersTable);

        assertEquals(result.toString().trim(), expectedResult);
    }

    @Test
    private void shouldDisplayCorrectValuesInConsoleFromMainMethod() {
        String input = "100\n";
        String expectedResult = "Give the maximum of the range (eg.100)|2|3|5|7|11|13|17|19|23|29|31|37|41|43|47|53|59|61|67|71|73|79|83|89|97";
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setIn(inContent);
        System.setOut(new PrintStream(result));

        PrimeNumbers.main(new String[]{});

        assertEquals(result.toString().trim().replaceAll("\\r\\n|\\r|\\n", "").trim(), expectedResult);
    }
}