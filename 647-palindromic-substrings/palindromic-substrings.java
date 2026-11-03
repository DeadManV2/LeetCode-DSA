class Solution {
    private static int[][] dp = new int[1001][1001];
    {
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
    }
    private int palindrome(String str, int i, int j){
        if(i >= j) return 1;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(str.charAt(i) == str.charAt(j)){
            return dp[i][j] = palindrome(str, i + 1, j - 1);
        }
        return dp[i][j] = 0;
   
    }
    public int countSubstrings(String s) {

        int ans  = 0;
        int n = s.length();

        for(int i = 0;  i < n; i++){
            for(int j = i; j < n; j++){
                if(palindrome(s, i, j) == 1){
                    ans++;
                }
            }
        }
        return ans;
        
    }
}