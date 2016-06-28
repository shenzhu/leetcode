// Version One: Recursion
public class Solution{
    public void findSpiralOrder(int[][] matrix, int x, int y, int rows, int cols, List<Integer> result){
        if(rows <= 0 || cols <= 0){
            return;
        }

        // First line
        for(int i = 0; i < cols; i++){
            result.add(matrix[x][y + i]);
        }

        // Right column
        for(int i = 1; i < rows - 1; i++){
            result.add(matrix[x + i][y + cols - 1]);
        }

        // Botton row
        if(rows > 1){
            for(int i = cols - 1; i >= 0; i--){
                result.add(matrix[x + rows - 1][y + i]);
            }
        }

        // Left column
        if(cols > 1){
            for(int i = rows - 2; i > 0; i--){
                result.add(matrix[x + i][y]);
            }
        }

        findSpiralOrder(matrix, x + 1, y + 1, rows - 2, cols - 2, result);
    }
    
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<Integer>();
    
        // Corner case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        findSpiralOrder(matrix, 0, 0, matrix.length, matrix[0].length, result);
        return result;
    }
}


// Version Two: Iteration
public class Solution{
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<Integer>();
        
        // Corner case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int x1 = 0;
        int y1 = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        while(rows >= 1 && cols >= 1){
            // Record the right down corner of the matrix
            int x2 = x1 + rows - 1;
            int y2 = y1 + cols - 1;

            // Whole first line
            for(int i = y1; i <= y2; i++){
                result.add(matrix[x1][i]);
            }

            // Right column
            for(int i = x1 + 1; i < x2; i++){
                result.add(matrix[i][y2]);
            }

            // Whole last row
            if(rows > 1){
                for(int i = y2; i >= y1; i--){
                    result.add(matrix[x2][i]);
                }
            }

            // Left column
            if(cols > 1){
                for(int i = x2 - 1; i > x1; i--){
                    result.add(matrix[i][y1]);
                }
            }

            // Update variable
            rows -= 2;
            cols -= 2;
            x1++;
            y1++;
        }

        return result;
    }
}
