class Solution {
    private final int[][] dir = {
        {-1,2}, {-1, -2}, {-2,+1}, {-2, -1},
        {1,2},{1,-2},{2,-1},{2,1}
    };
    private double dfs(int n, int k, int row, int col, double[][][] dp) {
        if(row < 0 || row >= n || col < 0 || col >=n) return 0;
        if(k == 0) return 1;

       if(dp[k][row][col] != -1) return dp[k][row][col];
        double ans = 0;
        for(int[] d : dir){
            int nrow = row + d[0];
            int ncol = col + d[1];

            ans += dfs(n, k-1, nrow, ncol,dp)/8.0;
        }
     return dp[k][row][col] = ans;
    //return ans;

    }
    public double knightProbability(int n, int k, int row, int col) {

        double[][][] dp = new double[k + 1][n][n];

        for (double[][] layer : dp) {
            for (double[] rowArr : layer) {
                Arrays.fill(rowArr, -1);
            }
        }
        
        return dfs(n, k, row, col, dp);

        
    }
}