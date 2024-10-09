package basics;

import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 *
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 *
 *         boolean [][] t0 = new boolean[][] {
 *                 {false,true,false,false},
 *                 {false,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,true}
 *         };
 *
 *         // t2 is a version of t2 with two quarter rotations
 *         boolean [][] t2 = new boolean[][] {
 *                 {true,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,false},
 *                 {false,false,true,false}
 *         };
 */
public class QRcode {

    protected boolean [][] data;

    /**
     * Create a QR code object
     * @param data is a n x n square matrix
     */
    public QRcode(boolean [][] data) {
        this.data = data;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */
    public static boolean compare(boolean[][] one, boolean[][] two){
        for(int i=0; i<one.length;i++){
            for(int j=0; j<one[0].length;j++){
                if(one[i][j] != two[i][j]){
                    return false;
                }

            }
        }
        return true;
    }
    public static boolean[][] rotate(boolean[][] matrix){
        int l = matrix.length;
        boolean[][] new_matrix = new boolean[l][l];
        for (int i =0; i<l; i++){
            for (int j=0;j<l;j++){

                new_matrix[i][j] = matrix[l-1-j][i];

            }
        }
        return new_matrix;
    }
    @Override
    public boolean equals(Object o) {
        QRcode matrix = (QRcode) o;
        boolean[][] rotated = rotate(matrix.data);
        for(int i= 0; i<=3;i++){
            if (compare(this.data, rotated)){
                return true;
            }
            rotated = rotate(rotated);

        }

        return false;
    }



}
