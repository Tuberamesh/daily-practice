/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        List<Integer> post=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
    
        postOrder(root);
        return post;
    }

    private void postOrder(TreeNode root) {
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        post.add(root.val);
}
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        preOrder(root);
        return ans;
    }
    private void preOrder(TreeNode root){
            if(root==null){
                return;
            }
            ans.add(root.val);
        preOrder(root.left);
         preOrder(root.right);
        
            
        }

       // preorderTraversal(root.val);
        
    }


    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     List <Integer> output=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
       // List <Integer> output=new ArrayList<>();

            inOrderTraversal(root);
            return output;
        }
        private void inOrderTraversal(TreeNode root){

        if(root==null){
            return ;
        }

        inOrderTraversal(root.left);
       // System.out.println(root.val +"->");
        output.add(root.val);
        inOrderTraversal(root.right);

    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        // Swap the children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}


//leetcode 637 average of levels in binary tree

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */





// class Solution {
//   public List<Double> averageOfLevels(TreeNode root) {

//     Queue<TreeNode> levelQueue = new LinkedList<>();
//     levelQueue.add(root);
//     levelQueue.add(null);

//     List<Double> avgList = new ArrayList<>();

//     while (levelQueue.peek() != null) {

//       double sum = 0;
//       int nodes = 0;

//       while (levelQueue.peek() != null) {

//         TreeNode node = levelQueue.poll();
//         sum += node.val;
//         nodes++;

//         if (node.left != null) levelQueue.add(node.left);
//         if (node.right != null) levelQueue.add(node.right);
//       }

//       levelQueue.add(levelQueue.poll());
//       avgList.add(sum / nodes);
//     }

//     return avgList;
//   }

// }


import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        if (root == null) return avgList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            avgList.add(sum / size);
        }

        return avgList;
    }
}



//mimimum depth of binary tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();

                // First time we see a leaf — that’s min depth
                if (node.left == null && node.right == null) {
                    return level;
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }

        return level;
    }
}


//maximum depth of binary tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 

class Solution {
    public int maxDepth(TreeNode root) {

         if (root == null) return 0;


        Queue<TreeNode> queueElements=new LinkedList<>();
        int countLevels=0;
        queueElements.add(root);
         
        while(!queueElements.isEmpty()){
            int countAtNodes=queueElements.size();
            // if(countAtNodes==0)
            // return countLevels;
        
        while(countAtNodes>0){
            TreeNode treeElements=queueElements.poll();

            if (treeElements.left != null)
                   queueElements.add(treeElements.left);
            if (treeElements.right != null)
                   queueElements.add(treeElements.right);


             countAtNodes--;
        }
        countLevels++;
        
    }
    return countLevels;
}
}

// Binary Tree Right Side View question no 199
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result =new ArrayList<Integer>();
        rightview(root,result,0);
        return result;
        
    }
    public void rightview(TreeNode curr,List<Integer> result, int currDepth){
         if(curr == null){
            return;

    }
   
    if(currDepth==result.size()){
        result.add(curr.val);
    }
    rightview(curr.right,result,currDepth+1);
    rightview(curr.left,result,currDepth+1);
}
}


class Solution {
    // Helper class to store node with its coordinates
    class Point {
        int row, col, val;
        Point(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap sorts by Column, then by Row, then PriorityQueue sorts by Value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>(); // Stores [TreeNode, row, col]
        
        q.offer(new Object[]{root, 0, 0});

        while (!q.isEmpty()) {
            Object[] current = q.poll();
            TreeNode node = (TreeNode) current[0];
            int row = (int) current[1];
            int col = (int) current[2];

            // Initialize nested maps if they don't exist
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            // Move left: row increases, col decreases
            if (node.left != null) q.offer(new Object[]{node.left, row + 1, col - 1});
            // Move right: row increases, col increases
            if (node.right != null) q.offer(new Object[]{node.right, row + 1, col + 1});
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int col : map.keySet()) {
            List<Integer> columnList = new ArrayList<>();
            for (int row : map.get(col).keySet()) {
                PriorityQueue<Integer> pq = map.get(col).get(row);
                while (!pq.isEmpty()) {
                    columnList.add(pq.poll()); // Extract sorted values for the same coordinate
                }
            }
            result.add(columnList);
        }
        return result;
    }
}