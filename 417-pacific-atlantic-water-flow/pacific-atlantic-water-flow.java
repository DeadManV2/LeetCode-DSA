class Solution {
    private int rows;
    private int cols;
    private int[][] dir = {
        {0,-1}, //left
        {-1, 0}, // up
        {0, 1}, // right
        {1, 0} // down
    };
    private void dfs(int row, int col, int[][] h, boolean[][] vis){

        vis[row][col] = true;
        for(int [] d : dir){
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(newRow < 0 || newCol < 0 || newCol >= cols || newRow >= rows) continue;

            if(vis[newRow][newCol]) continue;
            if(h[newRow][newCol] < h[row][col]) continue;
            dfs(newRow, newCol, h, vis);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] h) {

        rows  = h.length;
        cols = h[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // for Pacific

        for(int col = 0; col < cols; col++) {
            dfs(0, col, h, pacific);
        }
        for(int row = 0; row < rows; row++){
            dfs(row, 0, h, pacific);
        }

        // for atlantic

        for(int col = 0; col < cols; col++){
            dfs(rows - 1, col, h, atlantic);
        }
        for(int row = 0; row < rows; row++) {
            dfs(row, cols - 1, h, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < rows; r++){

            for(int c = 0; c < cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }  
        return res;       

        
    }
}