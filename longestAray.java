// Problem: Subarray Sum Equals K 560
// Given an array of integers nums and an integer k, return the total number of sub


class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum = sum + nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}


class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

  
            if (nums[i] == nums[i - 1]) {
                continue;
            }

     
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 1; 
            }
        }

         return Math.max(longest, count);
   // return longest;
    }
}
