//https://leetcode.com/problems/next-greater-element-i/description/
// Given two arrays nums1 and nums2 where nums1’s elements are a subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//leetcode problem 493
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         
        int n=nums1.length;
        int[] result=new int[n];

        for(int i=0;i<nums1.length;i++){

               result[i]=-1;

            for(int j=0;j<nums2.length;j++){

                if(nums1[i]==nums2[j]){

                    for(int k=j+1;k<nums2.length;k++){
                        if(nums1[i]<nums2[k]){
                        result[i]=nums2[k];

                        break;
                        }
                            
                    }
                    break;
                    
            }
           
        }
        
        
    }
    return result;
}
}

//leetcode problem 20
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

class Solution {
    public boolean isValid(String s) {
//         int a = s.length();
//         char[] arr = s.toCharArray();

//         if (a == 0) return false;
//         if (a % 2 != 0) return false;

//         // Use a "stack" pointer
//         char[] stack = new char[a];
//         int top = -1;

//         for (int i = 0; i < a; i++) {
//             char c = arr[i];

//             // push expected closing brackets
//             if (c == '(') stack[++top] = ')';
//             else if (c == '{') stack[++top] = '}';
//             else if (c == '[') stack[++top] = ']';
//             else {
//                 // check closing bracket
//                 if (top == -1 || stack[top] != c) return false;
//                 top--; // pop
//             }
//         }

//         return top == -1;
//     }
// }


    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {

      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');

      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }
    return stack.isEmpty();

  }

}