class Solution {

    public int findMin(int[] nums) {

        // 3, 4, 5, 1, 2
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[n-1] > nums[0]) return nums[0];
        int s = 0;
        int e = n - 1;

    while (s < e) {

        int mid = s + (e - s) / 2;

        if (nums[mid] > nums[e]) {
            s = mid + 1;
        } else {
            e  = mid;
        }
    }

    return nums[s];        

        
    }
}