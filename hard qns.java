// Problem: Count of Reverse Pairs
// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where 0 <= i < j

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid)
                  + mergeSort(nums, mid + 1, right);

        // Count reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Now merge the two sorted halves
        merge(nums, left, mid, right);

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}

//rainwater trapping problem 
// 42 question leetcode

// class Solution {
//     public int trap(int[] height) {
//         int n=height.length;
//         int [] prefix=new int[n];
//         int [] suffix=new int[n];
        
//         int total =0;

//         prefix[0]=height[0];
//         for(int i=1;i<n;i++){
//             prefix[i]=Math.max(prefix[i-1],height[i]);
//         }


//         suffix[n-1]=height[n-1];
//         for(int i=n-2;i>=0;i--){
//             suffix[i]=Math.max(suffix[i+1],height[i]);
//         }


//         for(int i=0;i<n;i++){
//             int leftmax=prefix[i]; 
//             int rightmax=suffix[i];

//             if(height[i]<leftmax && height[i]<rightmax){
//                 total+=Math.min(leftmax,rightmax)-height[i];
//             }
//         }

//         return total;
//     }
// }

