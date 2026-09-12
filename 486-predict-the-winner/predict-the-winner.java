class Solution {

    private int solve(int[] nums, int i, int j) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        // Take left
        int takeLeft = nums[i] - solve(nums, i + 1, j);

        // Take right
        int takeRight = nums[j] - solve(nums, i, j - 1);

        return Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {

        int result = solve(nums, 0, nums.length - 1);

        return result >= 0;
    }
}