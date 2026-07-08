class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;

        long[] pref = new long[n];
        pref[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i] - k)) {

                int start = map.get(nums[i] - k);

                long sum = (start == 0)
                        ? pref[i]
                        : pref[i] - pref[start - 1];

                ans = Math.max(ans, sum);
            }

            if (map.containsKey(nums[i] + k)) {

                int start = map.get(nums[i] + k);

                long sum = (start == 0)
                        ? pref[i]
                        : pref[i] - pref[start - 1];

                ans = Math.max(ans, sum);
            }

            if (!map.containsKey(nums[i])) {

                map.put(nums[i], i);

            } else {

                int old = map.get(nums[i]);

                long oldPrefix = (old == 0) ? 0 : pref[old - 1];
                long newPrefix = (i == 0) ? 0 : pref[i - 1];

                // Keep the occurrence with the smaller prefix sum
                if (newPrefix < oldPrefix) {
                    map.put(nums[i], i);
                }
            }
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}