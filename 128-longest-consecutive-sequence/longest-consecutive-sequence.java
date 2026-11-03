class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int ans = 0;

        for(int x : set){
            
            int len = 0;
            int t = x;
            if(!set.contains(x-1)){
            while(set.contains(t)){
                t = t + 1;
                len++;
            }
            ans = Math.max(ans, len);
            }
        }
        return ans;


        
    }
}