class Solution {
    public int maxChunksToSorted(int[] arr) {

    Stack<Integer> stack = new Stack<>();

    for(int x : arr){
        if(stack.isEmpty() || x >= stack.peek()){
            stack.push(x);
        }
        else{
            int max = stack.pop();
            while(!stack.isEmpty() && stack.peek() > x){
                stack.pop();
            }
            stack.push(max);
        }

    }
    return stack.size();
        
    }
}