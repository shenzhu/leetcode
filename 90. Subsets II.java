public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> subset, int[] nums, int start){
        list.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtrack(list, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}