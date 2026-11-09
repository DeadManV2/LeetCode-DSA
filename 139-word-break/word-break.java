class Solution {
    private static class TrieNode {
        boolean isEnd;
        Map<Character, TrieNode> hm;
        public TrieNode(){
            this.hm = new HashMap<>();
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(String word : wordDict) {
            hs.add(word);
        }
        TrieNode root = new TrieNode();

        for(String word : wordDict) {
            TrieNode  r = root;
            for(char ch : word.toCharArray()) {
                if(!r.hm.containsKey(ch)){
                    TrieNode t = new TrieNode();
                    r.hm.put(ch, t);
                  
                }
                  r = r.hm.get(ch);

            }
            r.isEnd = true;
        }

        int n = s.length();

        boolean[] dp = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(i == 0 || dp[i-1]){
                TrieNode curr = root;
                for(int j = i; j < n; j++) {
                    char c = s.charAt(j);
                    if(!curr.hm.containsKey(c)) {
                        break;
                    }
                    curr = curr.hm.get(c);
                    if(curr.isEnd){
                        dp[j] = true;
                    }
                }
            }
        }
    
    return dp[n-1];
        
        
    }
}