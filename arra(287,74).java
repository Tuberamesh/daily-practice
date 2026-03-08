
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