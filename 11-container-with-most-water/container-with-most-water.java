class Solution {
    public int maxArea(int[] h) {

        int l = 0;
        int r = h.length - 1;
        int ans  = 0;
        while( l < r){
            int ht = Math.min(h[l], h[r]);
            int wt = r - l;
            if(h[l] < h[r]){
                l++;
            }
            else{
                r--;
            }
            ans = Math.max(ans, wt*ht);
        }
        return ans;
        
        
    }
}