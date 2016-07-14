public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        
        // Init
        dp[0] = nums[0];
        int max = nums[0];
        
        // DP
        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        
        return max;
    }
}