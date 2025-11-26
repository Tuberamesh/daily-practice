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