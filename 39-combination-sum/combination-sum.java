
import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int target,
        int index,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Base case: target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore candidates starting from index
        for (int i = index; i < candidates.length; i++) {

            // Pruning
            if (candidates[i] > target) {
                continue;
            }

            // Pick
            current.add(candidates[i]);

            // Same index because reuse is allowed
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
