/*
Problem:
Given an integer array nums and an integer target, find the sum of three integers
such that the sum is closest to the target.

Platform:
LeetCode 16 - 3Sum Closest

Approach:
1. Sort the array.
2. Fix one element.
3. Use two pointers to find the closest sum.
4. Update the answer whenever a closer sum is found.

Time Complexity:
O(n^2)

Space Complexity:
O(1)
*/

import java.util.*;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Array must contain at least 3 elements.");
        }
        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int k = i + 1;
            int j = n - 1;

            while (j > k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
                if (sum == target)
                    return sum;
                else if (sum > target)
                    j--;
                else
                    k++;
            }

        }

        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        int closest = threeSumClosest(arr, target);
        System.out.println("The closest sum of 3 Number is : " + closest);

        sc.close();
    }
}
