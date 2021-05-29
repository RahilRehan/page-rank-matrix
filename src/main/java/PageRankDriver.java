package main.java;


public class PageRankDriver {


    public static void main(String[] args) {

        //inputs
        Integer[][] matrix = Processing.takeInputMatrix();
        Double dampingFactor = Processing.takeInputDampingFactor();
        Double[] columnVector = Processing.getColumnVector(dampingFactor, matrix.length);

        //logics
        Double[][] probabilityMatrix = PageRankMatrix.getRowProbabilityMatrix(matrix);
        Double[][] transposedMatrix = PageRankMatrix.transpose(probabilityMatrix);

        Double[] finalColumnMatrix = PageRankMatrix.calculatePageRank(transposedMatrix, columnVector, matrix.length);

        Processing.printRanking(finalColumnMatrix);

    }
}
