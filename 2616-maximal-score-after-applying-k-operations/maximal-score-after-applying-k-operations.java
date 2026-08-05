class Solution {
    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int num : nums) pq.offer(num);
        long sum = 0;

        while( !pq.isEmpty() && k > 0) {
            int x = pq.poll();
            sum += x;
            int ceil = (x + 3 - 1) / 3;
            pq.offer(ceil);
            k -= 1;
        }
        return sum;
        
    }
}