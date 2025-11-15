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

//problem no 229. Majority Element n/3

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Arrays.sort(nums);  
        List<Integer> list = new ArrayList<>();

        int n = nums.length;
        int limit = n / 3;

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > limit) {
                    list.add(nums[i - 1]);
                }
                count = 1;
            }
        }

        
        if (count > limit) {
            list.add(nums[n - 1]);
        }

        return list;
    }
}
