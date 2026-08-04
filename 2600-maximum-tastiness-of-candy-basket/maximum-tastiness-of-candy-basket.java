class Solution {
    private boolean check(int[] nums, int k, int d){

        int cnt  = 1;
        int prev = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            if((nums[i] - prev) >= d){
                cnt++;
                prev = nums[i];

            }
        }
        return cnt >= k;
    }
    public int maximumTastiness(int[] nums, int k) {

        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int ans  = -1;
        int h = nums[n-1] - nums[0];
        while(l <=  h){
            int mid = (l + h)/2;
            if(check(nums, k, mid)){
                ans  = mid;
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
      return ans;
        
    }
}