class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int[][] tmp = new int[board.length+1][board[0].length+1];
        for(int i=1;i<tmp.length;i++) {
            for(int j=1;j<tmp[0].length;j++) {
                tmp[i][j] = board[i-1][j-1];
            }
        }

        for(int i=1;i<tmp.length;i++) {
            for(int j=1;j<tmp[0].length;j++) {
                if(tmp[i][j] == 1) {
                    int top = tmp[i-1][j];
                    int corner = tmp[i-1][j-1];
                    int left = tmp[i][j-1];

                    tmp[i][j] = Math.min(top,Math.min(corner,left)) + 1;
                }
                answer = Math.max(tmp[i][j],answer);
            }
        }

        return answer*answer;
    }
}