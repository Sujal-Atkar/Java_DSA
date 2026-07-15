/*
Problem:
Given an integer array nums, return an array resultwer such that resultwer[i]
is equal to the product of all the elements of nums except nums[i].

Platform:
LeetCode 238 - Product of Array Except Self

Approach:
1. Traverse left to right to compute prefixProduct products.
2. Traverse right to left to compute suffix products.
3. Multiply prefixProduct and suffix values.

Time Complexity:
O(n)

Space Complexity:
O(1) extra space (excluding output array)
*/

import java.util.Scanner;

public class ProdcutofArrayExceptSelf {
    
        public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int prefixProduct = 1;
        int suffix = 1;

        result[0] = 1;

        // prefixProduct and Suffix Array
        for(int i = 1; i<n; i++){
            prefixProduct *= nums[i-1];
            result[i] = prefixProduct;
        }

        for(int i = n-2; i>=0; i--){
            suffix *= nums[i+1];
            result[i] *= suffix;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result[] = productExceptSelf(arr);
        for (int value : result) {

            System.out.print(value +" ");
        }
        sc.close();
    }
}
