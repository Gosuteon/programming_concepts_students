package basics;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] splitted = s.split("\n");

        int[][] matrice = new int[splitted.length][];
        for(int i = 0; i<splitted.length;i++){

            String[] finale = splitted[i].split( " ");

            matrice[i] = new int[finale.length];
            for( int j = 0; j<finale.length;j++){

                matrice[i][j] = Integer.parseInt(finale[j]);


            }
        }




        return matrice;
    }


    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int count = 0;
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length;j++){
                count += matrix[i][j];
            }
        }
         return count;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] newmatrice = new int[matrix[0].length][matrix.length];
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                newmatrice[j][i] = matrix[i][j];
            }
        }

         return newmatrice;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int[][] newmatrice = new int[matrix1.length][matrix2[0].length];
        for (int i=0; i< matrix1.length; i++){
            for (int j =0; j< matrix2.length; j++){
                for (int k = 0;k<matrix2[j].length;k++){
                    newmatrice[i][k] += matrix1[i][j] * matrix2[j][k];
                }
            }
        }
         return newmatrice;
    }
}