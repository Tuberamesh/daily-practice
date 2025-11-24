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


import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}


// import java.util.*;
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
        

//     if (strs == null || strs.length == 0)
//       return new ArrayList<>();

//     Map<String, List<String>> stringAnagramsMap = new HashMap<>();
//     for (String s : strs) {
//       char[] arr = s.toCharArray();
//       Arrays.sort(arr);
//       String key = String.valueOf(arr);

//       if (!stringAnagramsMap.containsKey(key))
//         stringAnagramsMap.put(key, new ArrayList<>());

//       stringAnagramsMap.get(key).add(s);
//     }

//     List<List<String>> resultList = new ArrayList<>();
//     for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
//       resultList.add(stringAnagrams.getValue());
//     }
//     return resultList;
//   }

//   public List<List<String>> groupAnagramsCategorizeByFrequency(String[] strs) {

//     // Check for empty inputs
//     if (strs == null || strs.length == 0)
//       return new ArrayList<>();

//     Map<String, List<String>> frequencyStringsMap = new HashMap<>();
//     for (String str : strs) {

//       String frequencyString = getFrequencyString(str);

//       // If the frequency string is present, add the string to the list
//       if (frequencyStringsMap.containsKey(frequencyString)) {
//         frequencyStringsMap.get(frequencyString).add(str);
//       }
//       else {
//         // else create a new list
//         List<String> strList = new ArrayList<>();
//         strList.add(str);
//         frequencyStringsMap.put(frequencyString, strList);
//       }
//     }

//     return new ArrayList<>(frequencyStringsMap.values());
//   }

//   private String getFrequencyString(String str) {

//     // Frequency buckets
//     int[] freq = new int[26];

//     // Iterate over each character
//     for (char c : str.toCharArray()) {
//       freq[c - 'a']++;
//     }

//     // Start creating the frequency string
//     StringBuilder frequencyString = new StringBuilder("");
//     char c = 'a';
//     for (int i : freq) {
//       frequencyString.append(c);
//       frequencyString.append(i);
//       c++;
//     }

//     return frequencyString.toString();
//   }
// }