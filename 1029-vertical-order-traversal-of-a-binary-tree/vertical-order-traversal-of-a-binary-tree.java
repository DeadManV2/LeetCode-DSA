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
    private static record Pair(TreeNode node, int row, int col){ 

    }
    private static record NodeInfo(int row, int value) {}
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<NodeInfo>> map = new HashMap<>();

        if(root == null) return res;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                Pair p = queue.poll();
                TreeNode node = p.node();
                int row = p.row();
                int col = p.col();
                min = Math.min(min, col);
                max = Math.max(max, col);
                if(!map.containsKey(col)){
                    map.put(col, new ArrayList<>() );
                }
                map.get(col).add(new NodeInfo(row, node.val));

                if(node.left != null) queue.offer(new Pair(node.left, row + 1, col - 1));
                if(node.right != null) queue.offer(new Pair(node.right, row + 1, col + 1));
            }
        }
        System.out.println(min +" " + max);
        for(int dist = min; dist <= max; dist++){
            
            List<NodeInfo> list = map.get(dist);
            list.sort((a, b) -> {

                if(a.row() != b.row()){
                    return Integer.compare(a.row(), b.row());
                }
                return Integer.compare(a.value(), b.value());
            });
            List<Integer> ans = new ArrayList<>();
            for(NodeInfo inf : list){
                ans.add(inf.value());
            }
            res.add(ans);
        }

       return res;
        
    }
}