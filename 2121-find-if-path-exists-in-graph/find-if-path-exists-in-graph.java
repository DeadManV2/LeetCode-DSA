class Solution {
    private boolean bfs(int src, int dest, boolean[] vis, List<Integer> g[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        vis[src] = true;
        while(!queue.isEmpty()){
            int cu = queue.poll();
            for(int cv : g[cu]){
                if(vis[cv] == false){
                    queue.offer(cv);
                    vis[cv] = true;
                }
            }
 
        }
        return vis[dest];

    }
    public boolean validPath(int n, int[][] edges, int src, int  dest ) {

        List<Integer> g[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
    g[i] = new ArrayList<>();
}
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        
    return bfs(src,dest, vis, g);
        
    }
}