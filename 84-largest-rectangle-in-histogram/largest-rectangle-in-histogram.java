class Solution {
    private int[] NSL(int[] arr) {
     Stack<Integer> st = new Stack<>();
     int n = arr.length;
     int[] res = new int[n];
     st.push(0);
     res[0] = -1;
     for(int i = 1; i < n; i++) {
        while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
            st.pop();
        }
        if(st.isEmpty()){
            res[i] = -1;
        }
        else {
            res[i] = st.peek();
        }
        st.push(i);
     }
     return res;
    }
    private int[] NSR(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        st.push(n-1);
        res[n-1] = n;

        for(int i =  n - 2; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n;
            }
            else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] nsl = NSL(heights);
        int[] nsr = NSR(heights);
        for(int i = 0; i < n; i++){
            System.out.print(nsl[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(nsr[i] + " ");
        }
        System.out.println();

        int ans = 0;
        for(int i = 0; i < n; i++){
            int l = nsl[i];
            int r = nsr[i];
            int w = r - l - 1;
            ans = Math.max(ans, w*heights[i]);
        }
        return ans;
        
    }
}