//problem no 169. Majority Element n/2 

class Solution {
    public int majorityElement(int[] nums) {

        // 1st approach is sorting

        
        // Arrays.sort(nums);
        // return nums[nums.length / 2];

       // 2nd approach is voting approach
         int vote=1;
        int test=nums[0];
        int n=nums.length;

        for(int i=1;i<n;i++){
            if(vote==0){
                vote++;
                test=nums[i];
            }
            else if (test==nums[i]) {
                vote++;
            }
            else{
                vote--;
            }
            
        }
        return test;
    }
}