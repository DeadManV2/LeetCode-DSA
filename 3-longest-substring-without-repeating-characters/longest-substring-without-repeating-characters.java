class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        char[] strArray = s.toCharArray();
        int n = s.length();
        int ans = 0;
        while(r < n) {
            while(set.contains(strArray[r])){               
                set.remove(strArray[l]);
                l++;
            }
          set.add(strArray[r]);
           ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
        
    }
}