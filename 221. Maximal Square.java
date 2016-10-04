public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        int maxLength = 0;
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    maxLength = Math.max(dp[i][j], maxLength);
                }
            }
        }
        
        return maxLength * maxLength;
    }
}