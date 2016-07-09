public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;      // corner case
        
        int[][] dp = new int[nums.length][2];

        // DP
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i - 1][1]), dp[i - 1][0]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }

        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}


// Optimized version
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;      // corner case
        
        int n = nums.length;
        int rob = 0;        // money if rob
        int notRob = 0;     // money if not rob
        
        // DP
        for(int i = 0; i < n; i++){
            int currRob = notRob + nums[i];     // money if rob current house
            notRob = Math.max(notRob, rob);     // money if not rob current house
            rob = currRob;
        }
        
        return Math.max(rob, notRob);
    }
}