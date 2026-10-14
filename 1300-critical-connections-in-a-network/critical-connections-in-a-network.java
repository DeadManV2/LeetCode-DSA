class Solution {
    private int timer = 1;
    public void dfs(int node, int parent, List<Integer> g[], boolean vis[], int entry_time[], int min_time[], List<List<Integer>> bridges){
        vis[node] = true;
        entry_time[node] = timer;
        min_time[node] = timer;
        timer++;
        for(int neigh : g[node]){
            if(neigh == parent) continue;
            if(!vis[neigh]){
                dfs(neigh, node, g, vis, entry_time, min_time, bridges);
                min_time[node] = Math.min(min_time[node], min_time[neigh]);
                if(min_time[neigh] > entry_time[node]){
                    bridges.add(new ArrayList<>(Arrays.asList(node, neigh)));
                }
            }
            else {
                min_time[node] = Math.min(min_time[node], entry_time[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<Integer> g[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }

        for(List<Integer> con : connections){
            g[con.get(0)].add(con.get(1));
            g[con.get(1)].add(con.get(0));
        }
        int entry_time[] = new int[n];
        int min_time[] = new int[n];
        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);
        List<List<Integer>> bridges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, -1, g, vis, entry_time, min_time, bridges);
            }
        }
        return bridges;

        
    }
}