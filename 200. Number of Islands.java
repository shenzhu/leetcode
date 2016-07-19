public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int numberOfIslands = 0;
        
        // Find islands
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    markIsland(grid, i, j);
                    numberOfIslands++;
                }
            }
        }
        
        return numberOfIslands;
    }
    
    private void markIsland(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        
        // Mark island
        grid[i][j] = '0';
        markIsland(grid, i - 1, j);
        markIsland(grid, i + 1, j);
        markIsland(grid, i, j + 1);
        markIsland(grid, i, j - 1);
    }
}