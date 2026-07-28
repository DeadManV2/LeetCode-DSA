class Solution {
    private void generateLps(String p, int m, int[] lps){

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
     int[] lps = new int[m];
     lps[0] = 0;
     generateLps(p,m, lps);
    int i = 0;
    int j = 0;
     while(i < n){
     if(s.charAt(i) == p.charAt(j)){
        i++;
        j++;
        if(j == m){
            return ( i - j);
        }
     }
     else {
        if(j != 0){
            j = lps[j - 1];
        }
        else {
            i++;
        }
     }
     }
     return -1;
    }
}