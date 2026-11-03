class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int l = 0;
        int h = n - 1;
        int ans =  0;
        int ht ;
        int wt;
        
        while(l < h){
            wt = h - l;
            if(height[l] > height[h]){
                ht = height[h];
                h--;
            }
            else {
                ht = height[l];
                l++;
            }
            ans = Math.max(ans, ht*wt);
        }
        return ans;
        
        
    }
}