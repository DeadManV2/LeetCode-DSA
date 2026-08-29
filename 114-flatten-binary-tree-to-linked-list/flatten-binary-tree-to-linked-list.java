class Solution {
    public void flatten(TreeNode root) {

        while (root != null) {

            // If there is no left subtree,
            // just move to the right.
            if (root.left != null) {

                // Find the rightmost node
                // of the left subtree.
                TreeNode temp = root.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                // Connect the original right subtree
                // after the left subtree.
                temp.right = root.right;

                // Move left subtree to right.
                root.right = root.left;

                // Remove left pointer.
                root.left = null;
            }

            // Move to next node.
            root = root.right;
        }
    }
}