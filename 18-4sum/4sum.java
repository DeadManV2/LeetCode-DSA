class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    void twoSum(int[] nums, int target, int a, int b, int l, int r) {

        while(l < r) {
            long sum = (long) a + b + nums[l] + nums[r];
            if(sum == target) {
                while(l < r && nums[l] == nums[l + 1]) l++;
                while(l < r && nums[r] == nums[r-1]) r--;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(a);
                tmp.add(b);
                tmp.add(nums[l]);
                tmp.add(nums[r]);
                res.add(tmp);
                l++;
                r--;
            }
            else if(sum < target) {
                l++;
            }
            else r--;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4) return new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                twoSum(nums, target, nums[i], nums[j], j + 1, n - 1);
            }
        }
        return res;
        
    }
}