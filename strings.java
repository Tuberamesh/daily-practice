// Given a string s, find the length of the longest substring without repeating characters.

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

// This code uses the sliding window idea to find the longest substring that has no repeating characters.
// I use a HashSet to keep track of the characters currently inside my window.
// left and right act like two pointers.
// right moves forward character by character.
// If I see a character that’s already in the set, I start moving left forward and remove characters from the set until the duplicate goes away.
// Every time I expand the window without duplicates, I update max with the current window size.
// Simple flow:
// Move right and read new characters.
// If it’s already in the set → shrink window from the left.
// If not → add to set and update longest length.
// This avoids re-checking characters and keeps the solution efficient.