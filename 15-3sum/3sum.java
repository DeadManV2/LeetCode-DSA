class Solution {
    void twoSum(int[] nums, int l, int r, int target, List<List<Integer>> res) {

        while(l < r) {
            long sum =  (long) nums[l] + nums[r];
            if(sum == target) {
                while(l < r && nums[l] == nums[l+1]) l++;
                while(l < r && nums[r] == nums[r-1]) r--;

                List<Integer> tmp = new ArrayList<>();
                tmp.add(-target);
                tmp.add(nums[l]);
                tmp.add(nums[r]);
                res.add(tmp);
                l++;
                r--;
                
            }
            else if( sum  < target) {
                l++;
            }
            else r--;
        }
        return;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++ ){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int target = -nums[i];

            twoSum(nums, i + 1, n - 1, target, res);

        }
        return res;
        
    }
}