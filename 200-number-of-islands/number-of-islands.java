class Solution {
    public void dfs(int i , int j , char[][] grid, int m, int n){

       grid[i][j] = '0';
       int[] dx = {1,0,-1,0};
       int[] dy = {0,1,0,-1};
       int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
       for(int[] d : dir){
        int dirX = i + d[0];
        int dirY = j + d[1];
        if(dirX < 0 || dirX >= m || dirY < 0 || dirY >=n ){
            continue;
        }
        if(grid[dirX][dirY] == '1'){
            dfs(dirX, dirY, grid, m, n);
        }
       }
    }
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int cnt  = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1'){
                    dfs(i, j, grid, m, n);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}