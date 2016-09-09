public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;
        for(int i=0;i<board.length;i++) if(board[i][0]=='O') linkedUnit(board,i,0);
        for(int i=1;i<board[0].length;i++) if(board[0][i]=='O') linkedUnit(board,0,i);
        for(int i=1;i<board[0].length;i++) if(board[board.length-1][i]=='O') linkedUnit(board,board.length-1,i);
        for(int i=1;i<board.length-1;i++) if(board[i][board[0].length-1]=='O') linkedUnit(board,i,board[0].length-1);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='1') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
                else continue;
            }
        }
    }
    private void linkedUnit(char[][] board, int x, int y){
        board[x][y] = '1';
        if(x-1>0&&board[x-1][y]=='O') linkedUnit(board, x-1, y);
        if(x+1<board.length&&board[x+1][y]=='O') linkedUnit(board, x+1, y);
        if(y-1>0&&board[x][y-1]=='O') linkedUnit(board, x, y-1);
        if(y+1<board[x].length&&board[x][y+1]=='O') linkedUnit(board, x, y+1);
    }
}