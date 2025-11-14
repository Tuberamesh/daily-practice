
/// question 74 search a 2d matrix..

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){

                if(matrix[i][j]==target)
                return true;
            }
        }
        return false;
    }
}

// question 287 find the duplicate number..
class Solution {
    public int findDuplicate(int[] nums) {

     

        int n=nums.length;
       // Arrays.sort(nums);
        
        // for(int i=0;i<n;i++){
        //     if(nums[i]==nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // return -1;
  
        int freq[] = new int [n+1];
        for(int i=0;i<n;i++){
            if(freq[nums[i]]==0){
                freq[nums[i]]+=1;
            }else {
                return nums[i];
            }
        }

        return 0;
    }
}

