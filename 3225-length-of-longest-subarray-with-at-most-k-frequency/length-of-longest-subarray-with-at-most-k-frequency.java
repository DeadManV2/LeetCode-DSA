class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        int ans = 0;
        while(r < n){
            map.put(nums[r], map.getOrDefault(nums[r],0) + 1);
            if(map.get(nums[r]) <= k){
                if(ans < r - l + 1){
                    ans = r - l + 1;
                }
            }
            while(map.get(nums[r]) > k){
                map.put(nums[l], map.getOrDefault(nums[l],0)-1);
                l++;
            }
            r++;

        }
        return ans;
        
    }
}