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
    Map<Integer, Integer> map = new HashMap<>();
    private TreeNode helper(int[] in, int sin, int ein, int[] post, int sp, int ep){
        if(sin > ein) return null;
        TreeNode root = new TreeNode(post[ep]);
        int idx = map.get(post[ep]);
        int a = idx - sin;
        int x = a + sp - 1;

        root.right = helper(in, idx + 1, ein, post, x + 1, ep - 1);
        root.left = helper(in, sin, idx - 1, post, sp, x);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = inorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, n - 1, postorder, 0, n - 1);
    }
}