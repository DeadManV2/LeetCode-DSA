class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        HashMap<Character, Integer> need = new HashMap<>();
        char[] tChar = t.toCharArray();
        char[] sChar = s.toCharArray();
        for(char ch : tChar){
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int needCnt  = need.size();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int haveCnt = 0;
        int res[] = new int[2];
        int resLen = Integer.MAX_VALUE;
        while(r < m){
            char ch = sChar[r];
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(need.containsKey(ch) && window.get(ch).equals(need.get(ch))){
                haveCnt++;
            }
            while(haveCnt == needCnt){
                if(r - l  + 1 < resLen){
                   resLen = r - l + 1;
                   res[0] = l;
                   res[1] = r;
                }
            
            char leftChar = sChar[l];
            window.put(leftChar, window.getOrDefault(leftChar,0) - 1);

            if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                haveCnt--;
            }
            l++;
            }
            r++;
        }
    return resLen == Integer.MAX_VALUE ? "": s.substring(res[0], res[1] + 1);
    }
}