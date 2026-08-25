class Solution {
    static record Pair(int dist, int row, int col, int usedObs) {}
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist(), b.dist()));

        pq.offer(new Pair(0,0,0,0));
        int[][] dir = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        int[][][] dist = new int[m][n][k+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][0] = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int distance = p.dist();
            int row = p.row();
            int col = p.col();
            int used = p.usedObs();
            if(row == m-1 && col == n-1) return distance;
            if(distance > dist[row][col][used]) continue;

            for(int[] d : dir){
                int nrow = row + d[0];
                int ncol = col + d[1];
                if(nrow < 0 || nrow >= m || ncol < 0 || ncol >=n ) continue;
                int newUsed = used + grid[nrow][ncol];
                if(newUsed > k) continue;
                int newDist = distance + 1;
                if(newDist < dist[nrow][ncol][newUsed]){
                    dist[nrow][ncol][newUsed] = newDist;
                    pq.offer(new Pair(newDist, nrow, ncol, newUsed));
                }
            }

        }

  return -1;

        
    }
}