class Solution {
    private Boolean[][] dp;

    private boolean solve(int  i, int j , String s, String p) {
        if(i == s.length()){
            if(j == p.length()) return true;
            while(j < p.length()){
                if(p.charAt(j) != '*'){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(j == p.length()) return false;

      if(dp[i][j] != null) return dp[i][j];
        if((i < s.length() && j < p.length()) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')){
            return dp[i][j] = solve(i + 1, j + 1, s, p);
        }
        if(j < p.length() && p.charAt(j) =='*'){
            boolean take = solve(i+1, j, s, p);
            boolean not_take = solve(i, j + 1, s, p);
            return dp[i][j] = take || not_take;
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(0, 0, s, p);
        
    }
}