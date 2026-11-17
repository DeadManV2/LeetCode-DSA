class Solution {
    public int maxProduct(int[] nums) {

        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int prod = 1;
        for(int i = 0; i < n; i++) {
           prod = prod * nums[i];
           ans = Math.max(ans, prod);
           if(prod == 0) prod = 1;
        }

        prod  = 1;
        for(int i = n - 1; i >= 0; i--) {
            prod = prod * nums[i];
            ans = Math.max(ans, prod);
            if(prod == 0) prod = 1;
        }
        return ans;
        
    }
}