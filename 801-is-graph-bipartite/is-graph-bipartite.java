class Solution {
    private boolean dfs(int src, int c, int[][] graph, int[] color){
 
        color[src] = c;
        int tmp = (c == 1) ? 2 : 1;
        for(int v : graph[src]){

            if(color[v] == c) return false;
            if(color[v] == -1){
                if(!dfs(v, tmp, graph, color)) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
       int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); 
        for(int i = 0;  i < n ; i++){
             if(color[i] == -1){
                if(!dfs(i, 1, graph, color)) return false;
             }
        }

      return true;  
        
        
    }
}