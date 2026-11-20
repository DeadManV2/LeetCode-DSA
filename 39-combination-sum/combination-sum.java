class Solution {
    private int n;
    private void solve(int[] a, int target, int idx, List<List<Integer>> res, List<Integer> tmp){
        if(idx == n) {
        if(target == 0) {
            res.add(new ArrayList<>(tmp));
           
        }
         return ;
        }
        if(a[idx] <= target) {
            target -= a[idx];
            tmp.add(a[idx]);
            solve(a, target, idx, res, tmp);
            target += a[idx];
            tmp.remove(tmp.size() - 1);

        }
        solve(a, target, idx + 1, res, tmp);
        return ;

    }
    public List<List<Integer>> combinationSum(int[] a, int target) {

        n = a.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        solve(a, target, 0, res, tmp);
        return res;
    }
}