package pl.primenumbers;
import java.util.Scanner;

public class PrimeNumbers {

    CommonOperations co;

    public PrimeNumbers() {
        co = new CommonOperations();
    }

    public PrimeNumbers(CommonOperations co) {
        this.co = co;
    }

    public int[][] createTable(int x) {
        //initialize and fill the table as follows:
        // |2|3|4|5|6...
        // |1|1|1|1|1...
        int[][] numbersTable = new int[x][2];
        for (int i = 0; i < x; i++) {
            numbersTable[i][0] = i + 2;
            numbersTable[i][1] = 1;
            //value one means that the value in the
            //above row is a prime number
        }
        return numbersTable;
    }

    public int[][] markNonPrimeFromTable(int[][] numbersTable, int range) {
        //marks non-prime numbers by insterting zeros in the second row of the table
        // |2|3|4|5|6...
        // |1|1|0|1|0...
        double tmp = 0;
        for (int divisor = 2; divisor <= range; divisor++) {
            for (int i = divisor - 1; i < numbersTable.length; i++) {
                if (co.isDivisible(numbersTable[i][0], divisor)) {
                    numbersTable[i][1] = 0; //mark all non-prime numbers
                }
            }
        }
        return numbersTable;
    }

    void showPrimeNumbers(int[][] numbersTable) {
        for (int i = 0; i < numbersTable.length; i++) {
            if (numbersTable[i][1] == 1) {
                System.out.print("|" + numbersTable[i][0]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give the maximum of the range (eg.100)");
        String s = in.nextLine();
        int size = Integer.parseInt(s) - 1;
        PrimeNumbers pm = new PrimeNumbers();
        int[][] numbersTable = pm.createTable(size);
        int root = new CommonOperations().floorRootValue(size);
        numbersTable = pm.markNonPrimeFromTable(numbersTable, root);
        System.out.println("");
        pm.showPrimeNumbers(numbersTable);
    }
}