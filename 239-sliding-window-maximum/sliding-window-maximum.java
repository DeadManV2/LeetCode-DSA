class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
       int l = 0;
       int r = 0;
        while(r < n){
             int x = nums[r];
            if(dq.isEmpty() || x <= dq.peekLast()){
                dq.offerLast(x);
            }
            else {
                while(!dq.isEmpty() && x > dq.peekLast()){
                    dq.pollLast();
                }
                dq.offerLast(x);
            }
            if((r - l + 1) == k) {
                ans[l] = dq.peekFirst();
                if(!dq.isEmpty() && dq.peekFirst() == nums[l]){
                    dq.poll();
                }
                l++;

            }

            r++;
        }
        
        return ans;
    }
}