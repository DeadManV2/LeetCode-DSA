class Solution {
    public int halveArray(int[] nums) {

        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            sum += num;
            pq.offer((double)num);
        }
        double half = (double)sum/2;
        int cnt = 0;
        double tmpSum = sum;
        while(tmpSum > half){
            double x = pq.poll();
            double halfX = x / 2;
            pq.offer(halfX);
            tmpSum -= halfX;
            cnt++;           

        }
        return cnt;
        
    }
}