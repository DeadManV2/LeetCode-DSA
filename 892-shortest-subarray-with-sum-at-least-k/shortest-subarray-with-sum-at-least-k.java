class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        int[] pref = new int[n + 1];
        pref[0] = 0;
        for(int i = 0; i < n; i++){
            pref[i+1] = pref[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){

            while(!dq.isEmpty() && (pref[i] - pref[dq.peekFirst()]) >=k){
                ans = Math.min(ans, i - dq.pollFirst());
            }
            while(!dq.isEmpty() && pref[i] <= pref[dq.peekLast()] ){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return ans == Integer.MAX_VALUE ? - 1 : ans; 
        
    }
}