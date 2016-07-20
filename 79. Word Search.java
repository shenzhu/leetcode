public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        
        char[] chars = word.toCharArray();
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                if(dfs(board, x, y, chars, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][]board, int x, int y, char[] chars, int i){
        if(i == chars.length) return true;
        if(x < 0 || y < 0 || x == board.length || y == board[x].length) return false;
        if(board[x][y] != chars[i]) return false;
        
        board[x][y] ^= 256;
        boolean exist = dfs(board, x + 1, y, chars, i + 1) ||
                        dfs(board, x, y + 1, chars, i + 1) ||
                        dfs(board, x - 1, y, chars, i + 1) ||
                        dfs(board, x, y - 1, chars, i + 1);
        board[x][y] ^= 256;
        return exist;
    }
}