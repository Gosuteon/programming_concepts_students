package oop;

import java.util.Arrays;
import java.util.Comparator;


public class KNN {
    static class Student {
        final double[] grades; // grades[i] = inginious grades obtained by this student for exercise i
        final boolean success;  // true if the student succeeded at the exam, false otherwise

        public Student(double[] grades, boolean success) {
            this.grades = grades;
            this.success = success;
        }
    }

    /**
     * Predict the success at the exam for a student given
     * - their grades on inginious for each exercise, and
     * - the historical data about past students.
     * grades.length = students[i].grades.length for all i (they all have followed exactly the same exercises)
     *
     * @param students the past students (inginious grades + exam result success/failure)
     * @param grades,  the inginious grades of a student for whom we want to predict the success
     * @param k        >= 1 the number of most similar students used to make the prediction
     * @return the prediction of success. True if the number of successes
     * among the k most similar students is > k/2, false otherwise
     */
    public static boolean predictSuccess(Student[] students, double[] grades, int k) {
        double[] distances = new double[students.length];
        for (int i = 0; i < students.length; i++) {
            distances[i] = euclideanDistance(students[i].grades, grades);
        }

        int[] indicesPlusProches = new int[k];
        for (int i = 0; i < k; i++) {
            int indexMinDistance = findMinDistanceIndex(distances);
            indicesPlusProches[i] = indexMinDistance;
            distances[indexMinDistance] = Double.MAX_VALUE;
        }
        int successes = 0;
        for (int index : indicesPlusProches) {
            if (students[index].success) {
                successes++;
            }
        }

        return successes > k / 2;
    }

    public static double euclideanDistance(double[] a, double[] b) {
        double dist = 0;
        for (int i = 0; i < a.length; i++) {
            dist += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(dist);
    }

    public static int findMinDistanceIndex(double[] distances) {
        double minDistance = Double.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


}
