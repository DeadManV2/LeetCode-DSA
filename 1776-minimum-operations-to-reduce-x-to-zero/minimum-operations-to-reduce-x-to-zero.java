class Solution {
    public int minOperations(int[] nums, int x) {

        int sum = Arrays.stream(nums).sum();
        int target = sum - x;
        if(target < 0) return -1;
        if(target == 0) return nums.length;

        int l = 0;
        int r = 0;
        int currSum = 0;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        while(r < n){
            currSum += nums[r];
            r++;
            while(currSum > target && l < n){
                currSum -= nums[l];
                l++;
            }
            if(currSum == target) {
                ans = Math.max(ans, r - l );
            }

        }
     return ans == Integer.MIN_VALUE ? -1 : n - ans;    
        
    }
}