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
