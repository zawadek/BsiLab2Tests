package pl.primenumbers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CommonOperationsTest {

    @DataProvider(name = "testFloorRootValueDataProvider")
    private static Object[][] numbers2() {
        return new Object[][] {{5,2}, {9,3}};
    }

    @Test(dataProvider = "testFloorRootValueDataProvider")
    public void shouldReturnCorrectFloorRootValue(int number, int expResult) {
        CommonOperations instance = new CommonOperations();
        int result = instance.floorRootValue(number);
        assertEquals(expResult, result);
    }

    @Test
    public void shouldReturnFalseFromIsDivisible() {
        int divident = 4;
        int divisor = 3;
        Boolean expResult = false;
        Boolean result = new CommonOperations().isDivisible(divident, divisor);
        assertEquals(expResult, result);
    }

    @Test
    public void shouldReturnTrueFromIsDivisible() {
        int divident = 6;
        int divisor = 3;
        Boolean expResult = true;
        Boolean result = new CommonOperations().isDivisible(divident, divisor);
        assertEquals(expResult, result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionFromIsDivisibleWhenDividedByZero() {
        int divident = 6;
        int divisor = 0;
        Exception exceptionResult = null;
        try {
            Boolean result = new CommonOperations().isDivisible(divident, divisor);
        }
        catch (Exception ex) {
            exceptionResult=ex;
        }
        assertNotEquals(null, exceptionResult);
        assertEquals(new IllegalArgumentException().getClass().getName(), exceptionResult.getClass().getName());
    }
}