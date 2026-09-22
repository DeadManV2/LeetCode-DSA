class Solution {
    int res = Integer.MAX_VALUE;
    public void twoSum(int[] nums, int target, int num, int l, int h){

        while( l < h) {
        int sum = num +  nums[l] + nums[h];
        if(sum == target) {
            res = sum;
        }
        if(res == Integer.MAX_VALUE) res = sum;
        if(Math.abs(sum - target) < Math.abs(res - target)){
            res = sum;
        }

        if(sum < target) {
        l++;
        }
        else {
           h--;
        }
        }


    }
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;  i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
          //  int newTarget = target - nums[i];

           twoSum(nums, target, nums[i], i + 1, n - 1);
        

        }
        return res;
        
    }
}