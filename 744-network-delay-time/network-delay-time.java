class Solution {

    static record Pair(int v, int w){}
    static record State(int time, int node){}
    public int networkDelayTime(int[][] times, int n, int k) {

        List<Pair>[] g = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            g[u].add(new Pair(v, w));
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b)-> Integer.compare(a.time(), b.time()));

        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        
        pq.offer(new State(0, k));
        while(!pq.isEmpty()) {
            State state = pq.poll();
            int t = state.time();
            int u = state.node();
            if(t > time[u]) continue;
            for(Pair p : g[u]){
                int v = p.v();
                int w = p.w();
                int newDist = t + w;
                if(newDist < time[v]){
                    time[v] = newDist;
                    pq.offer(new State(newDist, v));
                }
            }

        }
        int max = -1;
        for(int i = 1 ; i <= n; i++){
            if(time[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, time[i]);
        }
        return max;
        
    }
}