class Solution {
    public void dfs(int i , int j , boolean[][] vis, char[][] grid, int m, int n){

        if(vis[i][j] == true) return;
        vis[i][j] = true;
       int[] dx = {1,0,-1,0};
       int[] dy = {0,1,0,-1};
       for(int d = 0; d < 4; d++){
        int dirX = i + dx[d];
        int dirY = j + dy[d];
        if(dirX < 0 || dirX >= m || dirY < 0 || dirY >=n ){
            continue;
        }
        if(grid[dirX][dirY] == '1'){
            dfs(dirX, dirY, vis, grid, m, n);
        }
       }



    }
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for(boolean[] t : vis){
            Arrays.fill(t, false);
        }
       int cnt  = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1' && vis[i][j] == false){
                    dfs(i, j, vis, grid, m, n);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}