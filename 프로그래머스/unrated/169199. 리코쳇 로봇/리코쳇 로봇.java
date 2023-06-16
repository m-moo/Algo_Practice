import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] board) {
        // up ,right, down, left
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int r = board.length, c = board[0].length();

        /* init */
        char[][] boardMap = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        int[] goal = new int[2];
        int[] start = new int[2];

        for(int i=0;i< r;i++) {
            String line = board[i];
            if(line.indexOf('R') > -1) {
                start[0] = i;
                start[1] = line.indexOf('R');
            }
            if(line.indexOf('G') > -1) {
                goal[0] = i;
                goal[1] = line.indexOf('G');
            }
            boardMap[i] = line.toCharArray();
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            int cnt = curr[2];

            for(int i=0;i<4;i++) {
                int nx = x, ny = y;

                /* 막힐 때까지 직진 */
                while(true) {
                    /* 범위에 벗어날 경우 조정 */
                    if(nx >= boardMap.length || ny >= boardMap[0].length
                            || nx < 0 || ny < 0) {
                        nx -= dir[i][0];
                        ny -= dir[i][1];
                        break;
                    }

                    if(boardMap[nx][ny] == 'D') {
                        nx -= dir[i][0];
                        ny -= dir[i][1];
                        break;
                    }
                    nx += dir[i][0];
                    ny += dir[i][1];
                }

                if(boardMap[nx][ny] == 'G') return cnt+1;

                if(!visited[nx][ny]) {
                    q.add(new int[]{nx,ny,cnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}