class Solution {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        int idx = 0;
        int len = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == (nums[i-1] + 1)){
              len++;
            }
            else {
                len = 1;
            }
            
            if(i >= k - 1){
                if(len >= k){
                    res[idx++] = nums[i];
                }
                else {
                    res[idx++] = -1;
                }
            }
        }
    
        return res;
        
    }
}