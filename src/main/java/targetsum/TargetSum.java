package targetsum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Check if the input array of integers contains a pair that produces the given target in sum
 *
 */
public class TargetSum {
    public static void main(String[] args) {
        System.out.println(hasTargetSum(new int[]{2, 3, 5, 0}, 6));
        System.out.println(hasTargetSum(new int[]{2, 3, 5, 1}, 6));
        System.out.println(hasTargetSum(new int[]{2, -3, 5, 9}, 6));
        System.out.println(hasTargetSum(new int[]{0, 0, 6, 1}, 6));

        System.out.println();

        System.out.println(hasTargetSumOptimized(new int[]{2, 3, 5, 0}, 6));
        System.out.println(hasTargetSumOptimized(new int[]{2, 3, 5, 1}, 6));
        System.out.println(hasTargetSumOptimized(new int[]{2, -3, 5, 9}, 6));  //4, 9, 1, -3 -> -3, 1, 4, 9;
        System.out.println(hasTargetSumOptimized(new int[]{0, 0, 6, 1}, 6));
        // a + b = c ;  b = c - a; a = c - b
    }

    public static boolean hasTargetSum(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] + arr[k] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasTargetSumOptimized(int arr[], int target) {
        Map<Integer, Set<Integer>> numToIndices = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            numToIndices.computeIfAbsent(arr[i], k -> new HashSet<>()).add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            Set<Integer> indices = numToIndices.get(diff);
            if (indices != null &&
                    (indices.size() > 1
                    || indices.iterator().next() != i) ) {
                return true;
            }
        }

        return false;
    }
}
