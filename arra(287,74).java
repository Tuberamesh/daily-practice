
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

// question 994 rotten oranges..

class Solution {
    public int orangesRotting(int[][] grid) {
    
    if (grid == null || grid.length == 0) return -1;

    int rows = grid.length, cols = grid[0].length;
    int[][] time = new int[rows][cols];
    for (int i = 0; i < rows; i++)
      Arrays.fill(time[i], Integer.MAX_VALUE);

    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] == 2)
          dfs(grid, time, i, j, 0);

    int timeRequired = 0;
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] == 1) {
          if (time[i][j] == Integer.MAX_VALUE) return -1;
          timeRequired = Math.max(timeRequired, time[i][j]);
        }

    return timeRequired;
  }

  private void dfs(int[][] grid, int[][] time, int i, int j, int currentTime) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
        || grid[i][j] == 0 || currentTime >= time[i][j]) return;

    time[i][j] = currentTime;
    dfs(grid, time, i - 1, j, currentTime + 1);
    dfs(grid, time, i + 1, j, currentTime + 1);
    dfs(grid, time, i, j - 1, currentTime + 1);
    dfs(grid, time, i, j + 1, currentTime + 1);
  }
}
  

// question 347 top k frequent elements..
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> fm =new HashMap<>();
        List<Integer>[] bucket=new List[nums.length+1];

        for(int n:nums){
            fm.put(n,fm.getOrDefault(n,0)+1);
        }

        for(int key:fm.keySet()){
            int frequnecy=fm.get(key);
            if(bucket[frequnecy] ==null){
                bucket[frequnecy]=new ArrayList<>();
            }
            bucket[frequnecy].add(key);

        }
        int[] res=new int[k];
        int counter=0;

        for(int i=bucket.length-1;i>=0 && counter<k;i--){
            if(bucket[i]!=null){
                for(int n:bucket[i]){
                    if (counter <k);
                    res[counter++] =n;
                }
                
            }
        }
        return res;
        
    }
}
// question 238 product of array except self..
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
          int ans[]=new int[n];
        

        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        right[n-1]=1;
         for(int i=right.length-2;i>-1;i--){
            right[i]=right[i+1]*nums[i+1];
        }

         for(int i=0;i<n;i++){
            ans[i]=left[i]*right[i];
        }
        return ans;
        
    }
}


// 36 question valid sudoku..

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}


// question 128 longest consecutive sequence..
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int longest = 1;
        int currentStreak = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            // Case 1: Consecutive (Gap of 1)
            if (nums[i+1] - nums[i] == 1) {
                currentStreak++;
            } 
            // Case 2: Duplicate (Gap of 0)
            else if (nums[i+1] - nums[i] == 0) {
                continue; // Do nothing, just move to the next 'i'
            } 
            // Case 3: A real gap found!
            else {
                longest = Math.max(longest, currentStreak);
                currentStreak = 1; // Reset for the next sequence
            }
        }

        // Final check to see if the last sequence was the longest
        return Math.max(longest, currentStreak);
    }
}


// question 125 valid palindrome..

class Solution {
    public boolean isPalindrome(String s) {

         String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char [] arr=str.toCharArray();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int j=n-1-i;
            if(arr[i]!=arr[j])
            return false;
        }
        return true;

        
    }
}

// question 167 two sum 2 input array is sorted..
//time complexity is O(n^2)
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {

//         if(numbers.length==0){
//             return;
//         }

//         int n=numbers.length;
//         int res[]=new int[2];

//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(numbers[i]+numbers[j]==target){
//                     res[0]=i+1;
//                     res[1]=j+1;
//                 }
//             }
//         }

//         return res;
//     }
// }

// time complexity is O(n) and space complexity is O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int currentSum = numbers[l] + numbers[r];

            if (currentSum == target) {
                return new int[] {l + 1, r + 1};
            } 
            else if (currentSum > target) {               
                r--;
            } 
            else {               
                l++;
            }
        }

        return new int[0];
    }
}

// question 15 three sum..

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n=nums.length;
        if(nums==null || nums.length<3)
        return new ArrayList<>();

        Arrays.sort(nums);

        Set<List<Integer>> res=new HashSet<>();

        for(int i=0;i<n-1;i++){

        int left=i+1;
        int right=n-1;

        while(left<right){
            int sum = nums[i] + nums[left] + nums[right];

            if(sum==0){
                res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
            }

            else if(sum<0){
                left++;
            }
            else{
                right--;
            }
          
        }
        }

        return new ArrayList<>(res);
        
    }
}

// question 11 container with most water..
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;

        int left=0;
        int right=n-1;
        int max=0;

        while(left<right){

            int area= Math.min(height[left],height[right]) *( right-left);

            max=Math.max(area, max);

            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return max;
    }
}


// question 42 trapping rain water..
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right =n-1;
        int leftmax=0,rightmax=0;
        int total=0;

        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=leftmax){
                    leftmax=height[left];
                }
                else{
                    total+=leftmax-height[left];
                
                }left++;
            }
            else{
                  if(height[right]>=rightmax){
                    rightmax=height[right];
                }
                else{
                    total+=rightmax-height[right];
                    
                }right--;
            }
            }
             return total;
        }

       
        
    }

    // question 20 valid parentheses..

    class Solution {
    public boolean isValid(String s) {

      Stack<Character> stack=new Stack();  
      for(char c:s.toCharArray()){
        if(c=='(') stack.push(')');
        else if (c=='{') stack.push('}');
        else if (c=='[') stack.push(']');

        else if (stack.empty() || stack.pop()!=c)
        return false;

      }
      return stack.empty();

     
    
        
    }
}

// question 155 min stack..

class MinStack {
    Stack<Integer> stack;
     Stack<Integer> minstack;

    public MinStack() {
         minstack= new Stack<>();
         stack= new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minstack.isEmpty()|| val<=minstack.peek()){
            minstack.push(val);
        }
        
    }
    
    public void pop() {
        int popp=stack.pop();

        if(popp==minstack.peek()){
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */