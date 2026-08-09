class Solution {
    private int[] suffix;
    private int[][] dp;
    private int solve(int[] piles, int i, int M){

        if(i + 2 * M >= piles.length){
            return suffix[i];
        }
        if(dp[i][M] != -1) return dp[i][M];
        int res = 0;
        for(int x = 1; x <= 2*M; x++){
            int taken = suffix[i] - suffix[i + x];
            int opp = solve(piles, i + x, Math.max(x, M));
            int curr = suffix[i] - opp;
            res = Math.max(res, curr);
        }
    return dp[i][M] = res;

    }
    public int stoneGameII(int[] piles) {
        if(piles.length == 1) return piles[0];

        int n = piles.length;
        suffix = new int[n+1];
    
        for(int i = n - 1; i >= 0 ; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }
        dp = new int[n][n];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(piles, 0, 1);
      
        
    }
}