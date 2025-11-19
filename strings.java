class Solution {
    public int lengthOfLongestSubstring(String s) {

        //Set<character> charset=new HashSet<>();
        Set<Character> charset = new HashSet<>();


        int max=0;
        int left=0;
        int n=s.length();

        for(int right =0;right<n;right++){

         while(charset.contains(s.charAt(right))){
            charset.remove(s.charAt(left));
            left++;
         }


            charset.add(s.charAt(right));
            max=Math.max(max,right-left+1);
        }

        return max;
        
    }
}
