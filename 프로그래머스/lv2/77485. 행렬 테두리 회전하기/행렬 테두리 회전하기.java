class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        /* init board */
        int[][] board = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                board[i][j] = i*columns+j+1;
            }
        }
        int idx = 0;
        for(int[] q:queries) {
            int x1 = q[0]-1, y1 = q[1]-1;
            int x2 = q[2]-1, y2 = q[3]-1;

            int tmp = board[x1][y1]; // for corner
            int min = tmp;
            /* rotate left side */
            for(int i=x1;i<x2;i++) {
                board[i][y1] = board[i+1][y1];
                min = Math.min(min,board[i][y1]);
            }
            /* rotate bottom side */
            for(int i=y1;i<y2;i++) {
                board[x2][i] = board[x2][i+1];
                min = Math.min(min,board[x2][i]);
            }
            /* rotate right side */
            for(int i=x2;i>x1;i--) {
                board[i][y2] = board[i-1][y2];
                min = Math.min(min,board[i][y2]);
            }
            /* rotate top side */
            for(int i=y2;i>y1;i--) {
                board[x1][i] = board[x1][i-1];
                min = Math.min(min,board[x1][i]);
            }
            board[x1][y1+1] = tmp;
            answer[idx++] = min;
        }
        return answer;
    }
}