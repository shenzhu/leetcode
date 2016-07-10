public class Solution {
    public int robRange(int[] nums, int start, int end){
        if(nums == null || nums.length == 0 || start > end) return 0;       // corner case
        
        int rob = 0;
        int notRob = 0;
        for(int i = start; i <= end; i++){
            int currRob = nums[i] + notRob;
            notRob = Math.max(rob, notRob);
            rob = currRob;
        }
        
        
        return Math.max(rob, notRob);
    }
    
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }
}