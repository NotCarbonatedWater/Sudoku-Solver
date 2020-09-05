// import java.util.Scanner;
public class Main {
    public static void printBoard(int arr[][]) {
        for (int index1 = 0; index1 < arr.length; index1++) {
            if (index1 % 3 == 0)
                System.out.println("-------------------------");
            for (int index2 = 0; index2 < arr.length; index2++) {
                if (index2 % 3 == 0)
                    System.out.print("| ");
                System.out.print(arr[index1][index2] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }

    public static int[][] testPuzzleEasy01(int arr[][]) {
        arr[0] = new int[] { 2, 0, 5, 0, 0, 9, 0, 0, 4 };
        arr[1] = new int[] { 0, 0, 0, 0, 0, 0, 3, 0, 7 };
        arr[2] = new int[] { 7, 0, 0, 8, 5, 6, 0, 1, 0 };
        arr[3] = new int[] { 4, 5, 0, 7, 0, 0, 0, 0, 0 };
        arr[4] = new int[] { 0, 0, 9, 0, 0, 0, 1, 0, 0 };
        arr[5] = new int[] { 0, 0, 0, 0, 0, 2, 0, 8, 5 };
        arr[6] = new int[] { 0, 2, 0, 4, 1, 8, 0, 0, 6 };
        arr[7] = new int[] { 6, 0, 8, 0, 0, 0, 0, 0, 0 };
        arr[8] = new int[] { 1, 0, 0, 2, 0, 0, 7, 0, 8 };
        return arr;
    }

    public static int getNumOfBlanks(int arr[][]) {
        int blankCounter = 0;
        for (int index1 = 0; index1 < arr.length; index1++)
            for (int index2 = 0; index2 < arr.length; index2++)
                if (arr[index1][index2] == 0)
                    blankCounter++;
        return blankCounter;
    }
    
    public static boolean isSolved(int arr[][]) {
        return true;
    }

    public static boolean checkVertical(int arr[][]) {
        return true;
    }

    public static boolean checkHorizontal(int arr[][]) {
        return true;
    }

    public static int[][] fillBoard(int arr[][], int blanks) {
        while (isSolved(arr) == false) {

        }

        return arr;
    }

    public static void main(final String[] args) {
        int[][] Sudoku = new int[9][9];

        testPuzzleEasy01(Sudoku);
        System.out.println(getNumOfBlanks(Sudoku));
        printBoard(Sudoku);
        fillBoard(Sudoku, getNumOfBlanks(Sudoku));
    }
}