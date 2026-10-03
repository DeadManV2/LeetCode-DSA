/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean find(TreeNode root, int target) {
        if(root == null) return false;
        if(root.val == target) return true;
        return find(root.left, target) || find(root.right, target);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(root.val == p.val || q.val == root.val) return root;
        boolean pPresent = find(root.left, p.val);
        boolean qPresent = find(root.left, q.val);
        if(pPresent && qPresent){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(pPresent || qPresent) return root;

        return lowestCommonAncestor(root.right, p, q);
        
    }
}