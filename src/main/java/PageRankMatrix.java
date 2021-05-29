package main.java;

import java.text.DecimalFormat;

public class PageRankMatrix {

    public static Double[][] transpose(Double[][] matrix){
        int matrixSize = matrix.length;

        Double[][] transposeMatrix = new Double[matrixSize][matrixSize];
        for(int i = 0; i<matrixSize; i++)
            for (int j = 0; j < matrixSize; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        return transposeMatrix;
    }


    public static Double[] calculatePageRank(Double[][] matrix, Double[] columnVector, int matrixLength) {
        int k = 1;
        while(true){
            Double[] prevColumnVector = columnVector;
            columnVector = matrixMultiplication(matrix, columnVector, matrixLength);
            if(compareEquals(prevColumnVector, columnVector)){
                System.out.println("Number of iterations to converge: " + k);
                break;
            }
            k += 1;
            if(k == 250){
                System.out.println("Taking time to converge, FALLBACK!!! Number of iterations : " + k);
            }
        }
        return columnVector;
    }

    private static boolean compareEquals(Double[] prevColumnVector, Double[] columnVector) {
        for (int i = 0; i < columnVector.length; i++)
            if(!columnVector[i].equals(prevColumnVector[i])) return false;
        return true;
    }

    private static Double[] matrixMultiplication(Double[][] matrix, Double[] columnVector, int matrixLength) {
        Double[] newColumnVector = new Double[matrixLength];
        for (int i = 0; i < matrixLength; i++) {
            double ans = 0;
            for (int j = 0; j < matrixLength; j++) {
                ans += Double.parseDouble(getRoundedValue(matrix[i][j]*columnVector[j]));
            }
            newColumnVector[i] = ans;
        }
        return newColumnVector;
    }

    public static String getRoundedValue(Double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }

    public static Double[][] getRowProbabilityMatrix(Integer[][] matrix) {
        Double[][] probabilityMatrix = new Double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                probabilityMatrix[i][j] = Double.valueOf(matrix[i][j])/Double.valueOf(rowSum(i, matrix));
            }
        }
        return probabilityMatrix;
    }

    private static Integer rowSum(int i, Integer[][] matrix) {
        Integer sum = 0;
        for (int j = 0; j < matrix.length; j++) {
            sum += matrix[i][j];
        }
        return sum;
    }
}
