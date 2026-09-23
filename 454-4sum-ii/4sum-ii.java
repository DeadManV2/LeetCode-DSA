class Solution {

    public int fourSumCount(int[] n1, int[] n2, int[] n3, int[] n4) {

        int n = n1.length;
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
              
              long target = -(n1[i] + n2[j]);
              map.put(target, map.getOrDefault(target, 0) + 1);
            }
        }
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++){
                long sum = n3[i] + n4[j];
                if(map.containsKey(sum)){
                    res += map.get(sum);
                }
            }
        }
        return res;


        
    }
}