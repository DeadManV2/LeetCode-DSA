class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incoming = new int[numCourses];
        List<Integer> g[] = new ArrayList[5001];
        for(int i = 0; i <= 5000; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites) {
            incoming[pre[0]]++;
            g[pre[1]].add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(incoming[i] == 0){
               queue.offer(i);
            }
        }

        if(queue.size() == 0) return false;

        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int v : g[u]) {
                incoming[v]--;
                if(incoming[v] == 0)
                {
                    queue.offer(v);
                }
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(incoming[i] >= 1) return false;
        }
        return true;
        
    }
}