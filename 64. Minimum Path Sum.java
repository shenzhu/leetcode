public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;       // corner case
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Initialize side row and column
        for(int i = 1; i < m; i++){
            grid[i][0] += grid[i - 1][0];
        }
        for(int j = 1; j < n; j++){
            grid[0][j] += grid[0][j - 1];
        }
        
        // DP
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[m - 1][n - 1];
    }
}