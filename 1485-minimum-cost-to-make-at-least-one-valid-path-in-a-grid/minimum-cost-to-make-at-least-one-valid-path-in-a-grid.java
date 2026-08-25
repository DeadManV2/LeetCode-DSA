class Solution {
    static record Pair(int cost, int row, int col) {}
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost(), b.cost()));

        pq.offer(new Pair(0, 0, 0));
        int[][] cost = new int[m][n];
        for(int[] c : cost){
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        int[][] dir ={
            {0,1}, // 1
            {0,-1}, // 2
             {1, 0},// 3
             {-1,0} // 4
        };
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int c = p.cost();
            int row = p.row();
            int col = p.col();
            if(row == m-1 && col == n-1) return c;
            if(c > cost[row][col]) continue;
            
            for(int d = 0 ; d < 4; d++) {
                int nrow = row + dir[d][0];
                int ncol = col + dir[d][1];
                if(nrow < 0 || nrow >= m || ncol < 0 || ncol >= n) continue;
                int newCost = c + ((grid[row][col] == d + 1) ? 0 : 1);

                if(newCost < cost[nrow][ncol]){
                    cost[nrow][ncol] = newCost;
                    pq.offer(new Pair(newCost, nrow, ncol));
                }

            }

        }
        return -1;

        
    }
}