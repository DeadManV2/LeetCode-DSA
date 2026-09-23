class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            int tmp = sum - k;
            if(map.containsKey(tmp)) {
                cnt += map.get(tmp);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;

        
    }
}