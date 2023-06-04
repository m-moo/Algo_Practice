import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] countMap;
    int[] xDir = {-1,0,1,0};
    int[] yDir = {0,1,0,-1};
    
    public int solution(String[] maps) {
        countMap = new int[maps.length][maps[0].length()];

        /* map 초기화, start, lever 위치 확인 */
        char[][] map = new char[maps.length][maps[0].length()];

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for(int i=0;i<maps.length;i++) {
            String m = maps[i];
            if(m.contains("S")) {
                start[0] = i;
                start[1] = m.indexOf("S");
            }
            if(m.contains("L")) {
                lever[0] = i;
                lever[1] = m.indexOf("L");
            }
            if(m.contains("E")) {
                exit[0] = i;
                exit[1] = m.indexOf("E");
            }
            map[i] = m.toCharArray();
        }

        int toLever = bfs(map,start,lever);
        countMap = new int[maps.length][maps[0].length()]; // count 초기화
        int toExit = bfs(map,lever,exit);

        if(toLever == 0 || toExit == 0) return -1;

        return toLever+toExit-2;
    }
    
    public int bfs(char[][] map, int[] curr, int[] to) {
        Queue<int[]> q = new LinkedList<>();
        q.add(curr);

        countMap[curr[0]][curr[1]] = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];

            if(x == to[0] && y == to[1]) break; // 목적지 도착 시 break

            for(int i=0;i<4;i++) {
                int nx = x+xDir[i], ny = y+yDir[i]; // next location

                if(nx > -1 && ny > -1 && nx < map.length && ny <map[0].length
                    && countMap[nx][ny] == 0 && map[nx][ny] != 'X') {
                    countMap[nx][ny] = countMap[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return countMap[to[0]][to[1]];
    }
}