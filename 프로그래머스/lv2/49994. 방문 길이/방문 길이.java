import java.util.HashMap;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        HashMap<Character,Integer> dirMap = new HashMap<>();
        dirMap.put('U',0);
        dirMap.put('D',1);
        dirMap.put('R',2);
        dirMap.put('L',3);


        boolean[][][] visited = new boolean[11][11][4];
        int[] curr = {5,5};
        for(int i=0;i<dirs.length();i++) {
            int moveTo = dirMap.get(dirs.charAt(i));

            int nx = curr[0] + dir[moveTo][0];
            int ny = curr[1] + dir[moveTo][1];

            if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            if(!visited[curr[0]][curr[1]][moveTo]) {
                int oppositeIdx = (moveTo < 2) ? 1 - (moveTo % 2) : 3 - (moveTo % 2);
                visited[curr[0]][curr[1]][moveTo] = true;
                visited[nx][ny][oppositeIdx] = true;
                answer++;
            }
            curr[0] = nx;
            curr[1] = ny;
        }
        
        return answer;
    }
}