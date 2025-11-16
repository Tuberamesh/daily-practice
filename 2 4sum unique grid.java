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