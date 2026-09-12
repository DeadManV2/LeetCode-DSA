class Solution {

    private int[][] dp;

    private int solve(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }
        if(dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        // Take left
        int takeLeft = nums[i] - solve(nums, i + 1, j);

        // Take right
        int takeRight = nums[j] - solve(nums, i, j - 1);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
       int n = nums.length;
       dp = new int[n][n];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int result = solve(nums, 0, nums.length - 1);


        return result >= 0;
    }
}