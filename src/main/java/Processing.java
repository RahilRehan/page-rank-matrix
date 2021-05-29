package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class Processing {
    static Scanner scanner = new Scanner(System.in);
    public static Integer[][] takeInputMatrix(){
        System.out.print("Enter Size of Matrix: ");
        int matrixSize = scanner.nextInt();
        Integer[][] matrix = new Integer[matrixSize][matrixSize];

        for(int i=0; i<matrixSize;i++)
            for (int j = 0; j < matrixSize; j++) {
                System.out.printf("Enter (%d)(%d) element: ", i, j);
                matrix[i][j] = scanner.nextInt();
                while(!(matrix[i][j]==0 || matrix[i][j]==1)){
                    System.out.println("Only 0 and 1 values are allowed, please check!!");
                    System.out.printf("Enter (%d)(%d) element: ", i, j);
                    matrix[i][j] = scanner.nextInt();
                }
            }
        return matrix;
    }

    public static void printMatrix(Integer[][] matrix){

        System.out.println("Matrix is: ");
        int matrixSize = matrix.length;

        for (Integer[] doubles : matrix) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(doubles[j] + "  ");
            }
            System.out.println("\n");
        }
    }

    public static void printProbabilityMatrix(Double[][] matrix){

        System.out.println("Matrix is: ");
        int matrixSize = matrix.length;

        for (Double[] doubles : matrix) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(doubles[j] + "  ");
            }
            System.out.println("\n");
        }
    }



    public static Double takeInputDampingFactor() {
        System.out.print("Input damping factor: ");
        return scanner.nextDouble();
    }

    public static Double[] getColumnVector(Double dampingFactor, int matrixLength) {
        Double[] columnVector = new Double[matrixLength];
        for(int i=0; i< matrixLength; i++) columnVector[i] = dampingFactor;
        return columnVector;
    }

    public static void printColumnVector(Double[] columnVector) {
        System.out.println("Column Vector is: ");
        for (Double aDouble : columnVector) System.out.println(aDouble + " ");
    }

    public static void printRanking(Double[] finalColumnMatrix) {
        Pair[] pairs = new Pair[finalColumnMatrix.length];
        for (int i = 0; i < finalColumnMatrix.length; i++) {
            pairs[i] = new Pair(i, finalColumnMatrix[i]);
        }
        Arrays.sort(pairs);
        System.out.println("Page ranks and there values are ");
        for(Pair pair : pairs){
            System.out.printf("Rank is: %d and value is %f\n", pair.index, pair.value);
        }
    }
}
