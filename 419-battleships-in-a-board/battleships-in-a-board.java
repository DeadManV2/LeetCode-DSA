class Solution {
    private void dfs(char[][] board, int i, int j, int m, int n) {
          board[i][j] = '.';
          int[][] dir = {{1, 0},{-1,0},{0, 1}, {0, -1}};
          for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || x >= m || y < 0 || y >= n){
                continue;
            }
            if(board[x][y] =='X'){
                dfs(board, x, y, m, n);
            }
          }
    }
    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X'){
                    dfs(board, i , j, m ,n);
                    ans++;
                }
            }
        }
        return ans;
        
    }
}