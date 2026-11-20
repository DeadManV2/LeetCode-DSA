class Solution {
    private int n;
       public int findMin(int[] nums) {

        if(n == 1) return 0;
        if(nums[n-1] > nums[0]) return 0;
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

    return s; 
       }
    public int bs(int[] nums, int s, int e, int target) {

        while(s <= e) {
            int mid = (s + e)/2;
            if(target == nums[mid]) return mid;
            else if(nums[mid] < target) {
                s = mid + 1;
            }
            else e = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        n = nums.length;
        int minIdx = findMin(nums);
        System.out.println("MinIdx : " + minIdx);
        int f = bs(nums, 0, minIdx - 1, target);
        System.out.println(f);
        
        int s = bs(nums, minIdx, n - 1, target);
        System.out.println(s);
        return f == -1 ? s : f;
  
        
    }
}