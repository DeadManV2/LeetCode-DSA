class Solution {
    private static final long MOD = 1_000_000_007L;
    static record Pair(int node, long time){}
    private int djikstra(List<Pair> g[], int n) {
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);

        time[0] = 0;
        long[] ways = new long[n];
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time(),b.time()));

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int  u = p.node();
            long t = p.time();

            if(t > time[u]) continue;
            for(Pair p1 : g[u]) {
                int v = p1.node();
                long newTime = p1.time() + t;
                if(newTime < time[v]){
                    time[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v, newTime));
                }
                else if(newTime == time[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) ways[n-1];

    }
    public int countPaths(int n, int[][] roads) {

        List<Pair> g[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] r : roads) {
            int u = r[0];
            int v = r[1];
            int t = r[2];
            g[u].add(new Pair(v,t));
            g[v].add(new Pair(u, t));
        }

       return djikstra(g, n);

    }
}