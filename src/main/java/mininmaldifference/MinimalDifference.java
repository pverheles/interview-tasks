package mininmaldifference;

import java.util.Arrays;

/**
 *
 * Given input array of integers, divide into two parts, so that
 * the difference between their sums is minimal, and output this difference
 *
 */
public class MinimalDifference {
    static int[] weights = {1, 1, 1, 1, 1, 1};

    public static void main(String[] args) {
        int diff;

        if (weights.length == 0) {
            diff = 0;
        } else if (weights.length == 1) {
            diff = weights[0];
        } else if (weights.length == 2) {
            diff = Math.abs(weights[0] - weights[1]);
        } else {
            diff = calculateMinDiff(weights);
        }

        System.out.println(diff);
    }

    private static int calculateMinDiff(int[] weights) {
        Arrays.sort(weights);

        int sum1 = weights[weights.length - 1];
        int sum2 = weights[weights.length - 2];

        for (int i = weights.length - 3; i >= 0; i--) {
            if (sum2 > sum1) {
                sum1 += weights[i];
            } else {
                sum2 += weights[i];
            }
        }

        return Math.abs(sum1 - sum2);
    }
}
