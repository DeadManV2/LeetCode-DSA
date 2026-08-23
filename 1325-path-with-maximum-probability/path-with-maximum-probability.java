class Solution {
    static record Pair(int node, double succProb){}
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<Pair> g[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        double[] time  = new double[n];
        Arrays.fill(time, 0.0);
        time[start_node] = 1.0;
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double succ = succProb[i];
            g[u].add(new Pair(v, succ));
            g[v].add(new Pair(u, succ));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.succProb(), a.succProb()));
        pq.offer(new Pair(start_node,1));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node();
            double succ = p.succProb();
            if(u == end_node) return succ;
            if(succ < time[u]) continue;
            for(Pair next : g[u]){
                int v = next.node();
                double newSucc = succ * next.succProb();
                if(newSucc > time[v]) {
                    time[v] = newSucc;
                    pq.offer(new Pair(v, newSucc));
                }
            }
        }

        return 0;

    }
}