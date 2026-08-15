class Solution {
    public int findCenter(int[][] edges) {

        int[] degree = new int[edges.length + 2];

        for (int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
        }

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == edges.length) {
                return i;
            }
        }

        return -1;
    }
}   