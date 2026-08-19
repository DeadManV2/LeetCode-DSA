class Solution {
    static record Pair(int v, int w){}
    static record State(int cost, int node, int stops){}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<Pair> g[] = new ArrayList[n];
        for(int i = 0; i < n;  i++) {
            g[i] = new ArrayList<>();
        }

        for(int[] f : flights){
            int u = f[0];
            int v = f[1];
            int w = f[2];
            g[u].add(new Pair(v,w));
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.cost(), b.cost()));
        int maxFlights = k + 1;
        int[][] dest = new int[n][maxFlights + 1];
        for(int[] d : dest){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dest[src][0] = 0;
        pq.offer(new State(0, src, 0));

        while(!pq.isEmpty()) {
            State state = pq.poll();
            int cost = state.cost();
            int u = state.node();
            int stop = state.stops();
            if(u == dst) return cost;
            if(stop == maxFlights) continue;

            stop += 1;
            for(Pair p : g[u]) {
                int v = p.v();
                int w = p.w();
                int newCost = cost + w;
                if(newCost < dest[v][stop]) {
                    dest[v][stop] = newCost;
                    pq.offer(new State(newCost, v,stop));
                }

            }

        }

        return -1;
        
    }
}