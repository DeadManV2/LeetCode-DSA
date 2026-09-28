
class Solution {
    private boolean isLeaf(TreeNode root) {
        if(root.left == null && root.right == null) return true;

        return false;
    }
    private int findMax(TreeNode root) {
        int max = root.val;
        if(root.right == null) return max;
        max = Math.max(max, findMax(root.right));

        return max;
        
    }
    public TreeNode deleteNode(TreeNode root, int k) {

        if(root == null) return null;
        if(root.val > k){
            root.left = deleteNode(root.left, k);
        }
        else if(root.val < k){
            root.right = deleteNode(root.right, k);
        }
        else{
            // case 1 : leaf node
            if(isLeaf(root)){
                return null;
            }
            // case 2 : has 1 child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            // case 3: have 2 chaildren
            int max = findMax(root.left);
            root.val = max;
            root.left = deleteNode(root.left, max);

        }

        return root;
        
    }
}