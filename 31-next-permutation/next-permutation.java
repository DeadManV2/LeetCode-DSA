class Solution {
    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        int j = n - 1;
        
        while( j > 0){
          if(nums[j] > nums[j - 1]){
            idx = j - 1;
            break;
          }
          j--;
        }
        System.out.println(idx);
        if(idx == -1){
            reverse(nums, 0, n - 1);
            return;
        }
        for(int i = n - 1; i>=0; i--) {
        if(nums[i] > nums[idx]){
            swap(nums, idx, i);
            break;
        }
      }
      reverse(nums, idx + 1, n - 1);
    
    }
}