class Solution {
    private static boolean[][] dp = new boolean[21][21];
     {
                for(boolean[] row : dp){
            Arrays.fill(row, false);
        }
     }

    private boolean solve(int i , int j, String s, String p){
        if(j == p.length()){
            if(i == s.length()) return true;
            return false;
        }
        if(dp[i][j]  != false) return dp[i][j];
        boolean f = false;
        if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            f = true;
        }
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            boolean not_take = solve(i, j + 2, s, p);
            boolean take = f&&solve(i + 1, j, s, p);
            return dp[i][j] = take || not_take;
        }
        return dp[i][j] =f && solve(i+1, j + 1, s, p);
    }
    public boolean isMatch(String s, String p) {



        return solve(0, 0, s, p);
    }
}