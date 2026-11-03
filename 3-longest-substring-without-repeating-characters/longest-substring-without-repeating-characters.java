class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        char[] strArray = s.toCharArray();
        int ans = 0;
        while(r < n) {

            if(map.containsKey(strArray[r])) {
                int x = map.get(strArray[r]);
                if(x >= l){
                l = x + 1;
                }

            }
            map.put(strArray[r],r);
            ans = Math.max(ans, r - l + 1);
            r++;
 
        }
        return ans;
        
    }
}