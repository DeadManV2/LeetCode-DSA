class Solution {
    static record Pair(int row, int col){

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        if(grid[n-1][n-1] == 1) return -1;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(0,0));

        int[][] dir ={
            {1,0},{0,1},{-1,0},{0,-1},
            {1,1},{-1,-1},{-1,1},{1,-1}
        };
        int dist = 1;
        while(!pq.isEmpty()) {
        int size = pq.size();

        for(int i = 0; i < size; i++)
        {
            Pair  p = pq.poll();
            int x = p.row();
            int y = p.col();
            if(x == n-1 && y == n-1) return dist;
            System.out.print(x+ " " + y);
            for(int[] d : dir) {
                int nrow = x + d[0];
                int ncol = y + d[1];
                if(nrow < 0 || nrow >= n || ncol < 0 || ncol >=n) {
                    continue;
                }
                if(grid[nrow][ncol] == 0){
                    System.out.println(nrow + " -> " + ncol);
                    grid[nrow][ncol] = 1;
                    pq.offer(new Pair(nrow, ncol));
                }
            }
        }
        dist++;
       }
       return -1;

    }
}