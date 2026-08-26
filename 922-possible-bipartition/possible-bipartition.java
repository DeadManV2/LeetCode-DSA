class Solution {
    static record Pair(int u, int v){}
    private boolean dfs(List<Integer> g[], int u, int[] color, int c){
        color[u] = c;
       int tmp = (c == 1) ? 0: 1;
       for(int v : g[u]) {
        if(color[v] == c) return false;
        if(color[v] == -1) {
        if(!dfs(g,v,color, tmp)) return false;
        }
       }
      
     return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Integer> g[] = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            g[i] = new ArrayList<>();
        }
        for(int[] e : dislikes)
        {
            int u = e[0];
            int v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        for(int i = 1; i <= n; i++){
            if(color[i] == -1){
                if(!dfs(g,i,color,1)) return false;
            }
        }
        return true;
    }
}