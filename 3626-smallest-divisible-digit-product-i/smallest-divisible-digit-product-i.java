class Solution {
    private long product(String s){
        long ans = 1;
        for(int i = 0; i < s.length(); i++){
            ans = ans * (s.charAt(i) - '0');
        }
        return ans;
    }
    public int smallestNumber(int n, int t) {
          
        for(int i = n; i <= 100; i++){
            long res = product(String.valueOf(i));
            if(res % t ==0){
                return i;
            }
        }
        return -1;
    }
}