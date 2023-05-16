class Solution {
    int[] dx = {-1,0,1,0,-1,1,1,-1,-2,0,2,0};
    int[] dy = {0,1,0,-1,1,1,-1,-1,0,2,0,-2};
    
    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};

        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                String line = places[i][j];
                for(int k=0;k<5;k++) {
                    char c = line.charAt(k);
                    if(c == 'P') if(!check(i,j,k,places)) answer[i] = 0;
                }
            }
        }
        return answer;
    }
    
    public boolean check(int room, int x, int y, String[][] places) {
        for(int i=0;i<12;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx > -1 && ny > -1 && nx < 5 && ny < 5) {
                char c = places[room][nx].charAt(ny);
                if(c == 'P') {
                    if(i < 4) return false; // 사방
                    else if (i < 8) {
                        /* 테이블을 낀 대각선 */
                        if(places[room][x].charAt(ny) != 'X'
                        || places[room][nx].charAt(y) != 'X') return false;
                    }else {
                        /* 테이블을 낀 일직선 */
                        if(places[room][(x+nx)/2].charAt((y+ny)/2) == 'O') return false;
                    }
                }
            }
        }
        return true;
    }
}