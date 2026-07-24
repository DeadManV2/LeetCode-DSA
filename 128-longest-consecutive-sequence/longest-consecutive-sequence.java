class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x : nums) set.add(x);
       int ans = 0;
        for(int x : set){
            if(!set.contains(x - 1)){
                int len = 0;
                int t = x;
                while(set.contains(t)){
                    len++;
                    t = t + 1;
                }
                ans = Math.max(ans, len);

            }
        }
        return ans;
    }
}