public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> solution, int[] candidates, int remain, int start){
        if(remain < 0) return;
        if(remain == 0){
            list.add(new ArrayList<>(solution));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;       // jump duplicate numbers
            solution.add(candidates[i]);
            backtrack(list, solution, candidates, remain - candidates[i], i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}