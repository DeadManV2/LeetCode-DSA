class Solution {
    static record Pair(int node, int w){}
    static record State(int dist, int node){}
    private int[] djikstra(int src,  List<Pair> g[], int n, int threesold){
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.w() - b.w());
        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair state = pq.poll();
            int t = state.w();
            int u = state.node();
            if(t > time[u]) continue;

            if(t > threesold) continue;

            for(Pair p : g[u]){
                int v = p.node();
                int w = p.w();
                int newDist = t + w;
                if(newDist < time[v] && newDist <= threesold){
                    time[v] = newDist;
                    pq.offer(new Pair(v, newDist));
                }
            }
            
        }
        return time;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<Pair> g[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            g[u].add(new Pair(v, w));
            g[v].add(new Pair(u, w));
        }
         int ans = -1;
         int minCnt = Integer.MAX_VALUE;
        for(int src = 0; src < n; src++) {
            int[] dist = djikstra(src, g, n, distanceThreshold);
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(i!= src && dist[i] <= distanceThreshold) {
                    cnt++;
                }
            }
            if(cnt <= minCnt){
                minCnt = cnt;
                ans = src;
            }
        }
        return ans;
          
    }
}