class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for(String patt : patterns) {
            if(word.contains(patt)){
                cnt++;
            }
        }
        return cnt;
        
    }
}