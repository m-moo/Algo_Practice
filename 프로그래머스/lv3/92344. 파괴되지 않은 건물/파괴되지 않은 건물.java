class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int n = board.length, m = board[0].length;
        int[][] skillMap = new int[n+1][m+1];

        /* 스킬 누적합 표기 */
        for(int i=0;i<skill.length;i++) {
            int type = skill[i][0];
            int dgr = skill[i][5];
            dgr *= type == 1 ? -1 : 1;

            int sx = skill[i][1], sy = skill[i][2];
            int ex = skill[i][3], ey = skill[i][4];

            skillMap[sx][sy] += dgr;
            skillMap[sx][ey + 1] += (dgr * -1);
            skillMap[ex + 1][sy] += (dgr * -1);
            skillMap[ex + 1][ey + 1] += dgr;
        }

        /* 누적합 계산 */
        for(int x=0;x<n;x++) { //좌우
            for(int y=1;y<m;y++) {
                skillMap[x][y] += skillMap[x][y-1];
            }
        }
        for(int y=0;y<m;y++) { //상하
            for(int x=1;x<n;x++) {
                skillMap[x][y] += skillMap[x-1][y];
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] + skillMap[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}