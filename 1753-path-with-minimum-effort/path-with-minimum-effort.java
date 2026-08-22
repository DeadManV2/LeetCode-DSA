class Solution {
    static record Pair(int v, int w) {}
    static record DistPair(int diff, int row, int col) {}
    public int minimumEffortPath(int[][] h) {

        int[][] dir = {
            {1,0},{0,1},{-1,0},{0,-1}
        };
        int m = h.length;
        int n = h[0].length;

        int[][] dist = new int[m][n];
        for(int[]  d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<DistPair> pq = new PriorityQueue<>((a,b) -> a.diff() - b.diff());

        pq.offer(new DistPair(0, 0, 0));

        while(!pq.isEmpty()){
            DistPair  p = pq.poll();
            int diff = p.diff();
            int row = p.row();
            int col = p.col();
            if(row == m - 1 && col == n -1) return diff;

            for(int[] d : dir) {
                int nrow = row + d[0];
                int ncol = col + d[1];
                if(nrow < 0 || nrow >= m || ncol < 0 || ncol >= n) continue;

                int dff = Math.abs(h[nrow][ncol] - h[row][col]);
                int newDiff = Math.max(dff, diff);
                if(newDiff < dist[nrow][ncol]){
                    dist[nrow][ncol] = newDiff;
                    pq.offer(new DistPair(newDiff, nrow, ncol));
                }
            }
        }
    return -1;

        
    }
}