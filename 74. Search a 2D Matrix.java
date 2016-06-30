// Version One: Binary Search
public class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix[0].length == 0 || matrix[0][0] == 0){
            return false;
        }

        // Use binary search to find row
        int l = 0;
        int r = matrix.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        int row = r;
        if(row < 0) return false;

        // Use binary search to find target
        while(l <= r){
            int mid = (l + r) / 2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}


// Version Two
public class Solution{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix[0].length == 0 || matrix[0][0] == 0){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int i = 0, j = cols - 1;
        while(i < rows && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
