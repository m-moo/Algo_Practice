class Solution {
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int answer = 0;
        
        boolean[][] dangerZone = new boolean[row+2][col+2];
        
       
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
               if(board[i][j] == 1) {
                   int r = i+1, c = j+1;
                   dangerZone[r-1][c] = true;
                   dangerZone[r][c-1] = true;
                   dangerZone[r+1][c] = true;
                   dangerZone[r][c+1] = true;
                   dangerZone[r][c] = true;
                   dangerZone[r+1][c+1] = true;
                   dangerZone[r-1][c-1] = true;
                   dangerZone[r-1][c+1] = true;
                   dangerZone[r+1][c-1] = true;
               }
            }
        }
        
        for(int i=1;i<row+1;i++) {
            for(int j=1;j<col+1;j++) {
                if(!dangerZone[i][j]) answer++;
            }
        }
        return answer;
    }
}