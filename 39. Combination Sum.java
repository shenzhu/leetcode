public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> solution, int[] candidates, int remain, int start){
        if(remain < 0) return;
        if(remain == 0) {
            list.add(new ArrayList<>(solution));
            return;
        }

        // remain > 0
        for(int i = start; i < candidates.length; i++){
            solution.add(candidates[i]);
            backtrack(list, solution, candidates, remain - candidates[i], i);       // not i + 1 because we can reuse same elements
            solution.remove(solution.size() - 1);
        }
    }
}