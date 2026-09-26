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
    private Map<Integer, Integer> map = new HashMap<>();

    private TreeNode helper(int[] pre, int spr, int epr, int[] in, int sin, int ein) {
       
       if(spr > epr) return null;
        TreeNode root = new TreeNode(pre[spr]);
        int idx = map.get(root.val);
        int a = idx - sin; // # of element in LST.
        int x = a + spr;

        root.left = helper(pre, spr + 1, x, in, sin, idx-1);
        root.right = helper(pre, x + 1, epr, in, idx + 1, ein);

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
      for(int i = 0; i < n; i++) {
        map.put(inorder[i], i);
      }

      return helper(preorder, 0, n -1 , inorder, 0, n -1);

        
    }
}