class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num : piles){
            pq.offer(num);
        }
         
         int sum = 0;
         while(!pq.isEmpty() && k > 0){
            int x = pq.poll();
           // sum += x;
            int floor  = x / 2;
            x -= floor;
            pq.offer(x);
            k -= 1;
         }
         while(!pq.isEmpty()){
            int x = pq.poll();
            sum += x;
         }
         return sum;
    }
}