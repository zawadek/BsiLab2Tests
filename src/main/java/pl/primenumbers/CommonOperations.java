package pl.primenumbers;

public class CommonOperations {
    //calculate the biggest int lower than root value
    int floorRootValue(int number) {
        return (int) Math.sqrt(number);
    }

    //is the number divisable by the other one?
    boolean isDivisible(int divident, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        double result = divident / (double) divisor;
        if (result == (int) result) {
            return true;
        } else {
            return false;
        }
    }
}