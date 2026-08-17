class Solution {
    
    static record Pair(int row, int col){}
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] time = new int[m][n];
        for(int[] t : time) {
            Arrays.fill(t, -1);
        }
        boolean[][] vis = new boolean[m][n];

        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
               if(grid[i][j] == 2){
                time[i][j] = 0;
                queue.offer(new Pair(i, j));
               }
            }
        }
        int[][] dir = {{1,0}, {-1, 0}, {0, 1}, { 0, -1}};
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            for(int [] d : dir) {
                int nrow = row + d[0];
                int ncol = col + d[1];
                if(nrow < 0 || nrow >= m || ncol < 0 || ncol >= n) {
                    continue;
                }
                if(grid[nrow][ncol] == 1) {
                    queue.offer(new Pair(nrow, ncol));
                    time[nrow][ncol] = time[row][col] + 1;
                    //vis[nrow][ncol] = true;
                    grid[nrow][ncol] = 2;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) return -1;

                ans = Math.max(ans, time[i][j]);
            }
        }
        return ans;
    }
}