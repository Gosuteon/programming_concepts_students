package basics;

import java.util.ArrayList;

public class MagicSquare {


    /**
     * A magic square is an (n x n) matrix such that:
     *
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     *
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */
    public static boolean isMagicSquare(int [][] matrix) {
        int l = matrix.length;
        int[][] tempo = matrix;
        int sum = 0;
        for (int i = 0; i<l;i++){
            sum += matrix[i][i];
        }
        // check range

        for(int i = 0; i<l; i++){
            for(int j =0; j<l; j++){
                if(matrix[i][j]==0 || matrix[i][j] > l*l){
                    return false;
                }
            }
        }
        // test if square
        if (matrix.length != matrix[0].length){
            return false;
        }

        // check num diff
        for (int i = 0; i<l;i++){
            for (int j = 0; j<l;j++){
                for (int k = 0; k<l; k++){
                    for (int m = 0; m<l; m++){
                        if(i!=k && j!=m && matrix[i][j]==tempo[k][m]){
                            return false;
                        }
                    }
                }
            }
        }

        // sum ligne
        for (int i= 0; i<l;i++){
            int count = 0;
            for (int j=0; j<l;j++){
                count += matrix[i][j];
            }
            if (count != sum){
                return false;
            }


        }
        // sum colonne
        for (int i= 0; i<l;i++){
            int count = 0;
            for (int j=0; j<l;j++){
                count += matrix[j][i];
            }
            if (count != sum){
                return false;
            }


        }
        // sum diagonal 1
        int count = 0;
        for (int i = 0; i<l;i++){
            count += matrix[i][i];
        }

        if (count != sum){
            return false;
        }

        // sum diagonal 2
        count = 0;
        for (int i = 0; i<l; i++){
            count += matrix[i][l-1-i];
        }
        return count == sum;


    }
}
