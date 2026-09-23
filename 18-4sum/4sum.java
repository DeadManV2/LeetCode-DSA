class Solution {
List<List<Integer> >  res = new ArrayList<>();
    void twoSum(int[] nums, long target, int n1, int n2, int l, int h){
        
        while(l < h) {
            long sum = (long)n1 + n2 + nums[l] + nums[h];
            if(sum == target){

                List<Integer> ans = new ArrayList<>();
                ans.add(n1);
                ans.add(n2);
                ans.add(nums[l]);
                ans.add(nums[h]);



                res.add(ans);
                while(l < h && nums[l] == nums[l + 1]) l++;
                while(l < h && nums[h] == nums[h-1]) h--;
                l++;
                h--;
            }
            else if(sum < target){
                l++;
            }
            else {
                h--;
            }

        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        
        Arrays.sort(nums);
        int n = nums.length;

       for(int i = 0; i < n - 3; i++){
       if(i > 0 && nums[i] == nums[i-1] ) continue;
        for(int j =  i + 1; j < n - 2; j++){
          if(j > i+1 && nums[j] == nums[j-1]) continue;
        
            twoSum(nums, target,nums[i], nums[j] ,j + 1, n - 1);
        }
       }
      return res;
        
    }
}