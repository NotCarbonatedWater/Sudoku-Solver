import java.util.Scanner;
import java.util.ArrayList;

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

    public static void printBlanks(int arr[][]) {
        for (int index1 = 0; index1 < arr.length; index1++) {
            for (int index2 = 0; index2 < 2; index2++) {
                System.out.print(arr[index1][index2] + " ");
            }
            System.out.println("-------------------------");
        }
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

    public static int[][] getListOfBlanks(int arr[][], int arrBlank[][]) {
        int blankCounter = 0;
        for (int index1 = 0; index1 < arr.length; index1++)
            for (int index2 = 0; index2 < arr.length; index2++)
                if (arr[index1][index2] == 0) {
                    arrBlank[blankCounter][0] = index1;
                    arrBlank[blankCounter][1] = index2;
                    blankCounter++;
                }

        return arrBlank;
    }

    public static boolean horizontalChecker(int arr[][], int currentNumCurrPosBlankList, int arrBlankList[][], int currrentPosBlankList) {
        for (int index = 0; index < arr.length; index++)
            if (arr[arrBlankList[currrentPosBlankList][0]][index] == currentNumCurrPosBlankList)
                return false;
        return true;
    }

    public static boolean verticalChecker(int arr[][], int currentNumCurrPosBlankList, int arrBlankList[][], int currrentPosBlankList) {
        for (int index = 0; index < arr.length; index++) 
            if (arr[arrBlankList[currrentPosBlankList][1]][index] == currentNumCurrPosBlankList)
                return false;
        return true;
    }

    public static int[][] fillBoard(int arr[][], int arrBlankList[][], int NumOfBlanks) {
        int currrentPosBlankList = 0;
        int currentNumCurrPosBlankList = 0;
        boolean isSolved = false;

        while (isSolved == false) {

            System.out.println("currrentPosBlankList: " + currrentPosBlankList);
            
            if (horizontalChecker(arr, currentNumCurrPosBlankList, arrBlankList, currrentPosBlankList) == true && verticalChecker(arr, currentNumCurrPosBlankList, arrBlankList, currrentPosBlankList) == true) {
                System.out.println("TRUE");
                arr[arrBlankList[currrentPosBlankList][0]][arrBlankList[currrentPosBlankList][1]] = currentNumCurrPosBlankList; // pin to board
                currrentPosBlankList++; 
                currentNumCurrPosBlankList = 0;
            }
            
            currentNumCurrPosBlankList++;


            if (currentNumCurrPosBlankList > 9) {
                arr[arrBlankList[currrentPosBlankList][0]][arrBlankList[currrentPosBlankList][1]] = 0; // pin to board
                currrentPosBlankList--;
                if (arr[arrBlankList[currrentPosBlankList][0]][arrBlankList[currrentPosBlankList][1]] + 1 > 9) {
                    arr[arrBlankList[currrentPosBlankList][0]][arrBlankList[currrentPosBlankList][1]] = 0;
                    currrentPosBlankList--;
                }
                // currentNumCurrPosBlankList = 0;

            }


            if (currrentPosBlankList>=NumOfBlanks) {
                System.out.println("Board is Solved");
                isSolved = true;
            }
            if (currrentPosBlankList < 0) {
                System.out.println("Error With Board Input");
                isSolved = true;
            }

            
        }
        return arr;
    }

    public static void main(final String[] args) {
        int[][] Sudoku = new int[9][9];
        testPuzzleEasy01(Sudoku);
        int[][] SudokuBlank = new int[getNumOfBlanks(Sudoku)][2];
        getListOfBlanks(Sudoku, SudokuBlank);
        printBoard(Sudoku);
        printBlanks(SudokuBlank);
        // -----------------------------------------------------------
        fillBoard(Sudoku, SudokuBlank, getNumOfBlanks(Sudoku));
        printBoard(Sudoku);
    }
}