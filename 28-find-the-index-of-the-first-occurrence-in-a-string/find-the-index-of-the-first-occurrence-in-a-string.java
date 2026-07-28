class Solution {
    private void generateLps(String p, int[] lps){
        int m =  p.length();
        for(int i = 1; i < m; i++){
            int x = lps[i - 1];
            while(p.charAt(i) != p.charAt(x)){
                if(x == 0){
                    x = -1;
                    break;
                }
                x = lps[x-1];

            }
        lps[i] = x + 1;
        }
    }

    public int strStr(String s, String p) {
     int n = s.length();
     int m = p.length();
     String T = p + "$" + s;
     System.out.println(T);
     int[] lps = new int[T.length()];
     lps[0] = 0;
     generateLps(T,lps);
     for(int t = 0; t < T.length(); t++){
        System.out.print(lps[t] + " ");
        if(lps[t] == m){
            return t - 2 * m;
        }
     }
 
     return -1;
    }
}