public class Solution {
    public int[][] generateMatrix(int n) {
        // Corner case
        if(n < 1) return new int[0][0];
        
        int[][] result = new int[n][n];
        
        int k = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        while(top < bottom){
            for(int j = left; j < right; j++){
                result[top][j] = k;
                k++;
            }
            for(int i = top; i < bottom; i++){
                result[i][right] = k;
                k++;
            }
            for(int j = right; j > left; j--){
                result[bottom][j] = k;
                k++;
            }
            for(int i = bottom; i > top; i--){
                result[i][left] = k;
                k++;
            }
            
            // Update variables
            top++;
            bottom--;
            left++;
            right--;
        }
        
        if(n % 2 != 0){
            result[n / 2][n / 2] = k;
        }
        return result;
    }
}