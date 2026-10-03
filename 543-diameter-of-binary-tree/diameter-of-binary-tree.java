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
    private static record NodeInfo(int ht, int dia){

    }
    private NodeInfo diameter(TreeNode root){
        if(root == null) return new NodeInfo(-1, -1);
        NodeInfo l = diameter(root.left);
        NodeInfo r = diameter(root.right);
        return new NodeInfo(Math.max(l.ht, r.ht) + 1, Math.max(l.ht + r.ht + 2, Math.max(l.dia, r.dia)));
    }
    public int diameterOfBinaryTree(TreeNode root) {

        NodeInfo info = diameter(root);
        return info.dia();      
    }
}