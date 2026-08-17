class Solution {
    static record Pair(int time, int row, int col){

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int[][] time = new int[n][n];
        for(int[] t : time) {
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        time[0][0] = 1;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time() - b.time());
        pq.offer(new Pair(1,0,0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int t = p.time;
            int i = p.row;
            int j = p.col;
            if(t > time[i][j]){
                continue;
            }
            for(int[] d : dir) {
                int nrow = i + d[0];
                int ncol = j + d[1];
                if(nrow < 0 || nrow >= n || ncol < 0 || ncol >=n) {
                    continue;
                }
                
                if(grid[nrow][ncol] == 0){
                    if(time[nrow][ncol] > t + 1){
                        time[nrow][ncol] = t + 1;
                        pq.offer(new Pair(t + 1, nrow, ncol));
                    }
                }

            }
        }
        System.out.println(time[n-1][n-1]);
        return time[n-1][n-1] == Integer.MAX_VALUE ? -1 : time[n-1][n-1];
    }
}