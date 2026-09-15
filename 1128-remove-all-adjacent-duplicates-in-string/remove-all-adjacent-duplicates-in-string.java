class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        if(n == 0 || n == 1) return s;
        st.push(s.charAt(0));

        for(int i = 1; i < n; i++){
            if(!st.isEmpty() && st.peek() == s.charAt(i)){
                st.pop();
            }
            else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();

        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.reverse().toString();
        
    }
}