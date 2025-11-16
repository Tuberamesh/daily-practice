// https://leetcode.com/problems/two-sum/

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {         
            for (int j = i + 1; j < nums.length; j++) { 
                if (nums[i] + nums[j] == target) {
                    result[0] = i;   
                    result[1] = j;
                    return result;   
                }
            }
        }

        return result; 
    }
}

// leetcode 62. Unique Paths 

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] grid=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(i==0 || j==0){
                    grid[i][j]=1;
                }
                else{
                    grid[i][j]=grid[i][j-1] + grid[i-1][j];
                }

            }
        }
        return grid[m-1][n-1];
        
    }
}


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Very important
        
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        // Skip duplicate left
                        while (left < right && nums[left] == nums[left - 1]) left++;

                        // Skip duplicate right
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
