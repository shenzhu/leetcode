public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> subset, int[] nums, int start){
        list.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            backtrack(list, subset, nums, i + 1);       // use i + 1 to jump over previous number
            subset.remove(subset.size() - 1);
        }
    }
}