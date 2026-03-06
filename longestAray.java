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

// Problem: Longest Consecutive Sequence 128
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence


class Solution1{
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

// question 26 Remove Duplicates from Sorted Array
//my solution
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
             return 0;

        }
        Arrays.sort(nums);
        int k=1;
        int result[]=new int[nums.length];
        result[0]=nums[0];
   
        for(int i=1;i<nums.length;i++){
                if(nums[i-1]!=nums[i]){
                    result[k]=nums[i];
                    k++;
                }
        }
                
            for(int i=0;i<k;i++){
                nums[i]=result[i];
    }
    return k;
    }
}
// better solution
//question 26 Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
         int k = 1; 
        
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
             
                nums[k] = nums[i]; 
                k++;
            }
        }
        
    
        return k;
    }
}



class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> s1=new HashMap<>();
        Map<Character,Integer> s2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            s1.put(c,s1.getOrDefault(c,0)+1);
        }

        // add we use in hset for listn and aray for set. but here we puting in a slots.. 

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            s2.put(c,s2.getOrDefault(c,0)+1);
        }
 
        return s1.equals(s2);
 
        
    }
}