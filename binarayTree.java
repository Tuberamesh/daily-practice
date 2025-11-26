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