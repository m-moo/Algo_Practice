import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        int[] answer;

        int r = maps.length;
        int c = maps[0].length();
        visited = new boolean[r][c];
        List<Integer> rs = new ArrayList<>();

        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int sum = dfs(maps,i,j,r,c);
                    rs.add(sum);
                }
            }
        }
        
        if(rs.isEmpty()) return new int[]{-1};
        else {
            answer = new int[rs.size()];
            Collections.sort(rs);
            for(int i=0;i<answer.length;i++) {
                answer[i] = rs.get(i);
            }
        }
        
        return answer;
    }
    
    public int dfs(String[] maps, int x, int y, int r, int c) {
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0';

        for(int i=0;i<dir.length;i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c){
                if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                    sum += dfs(maps,nx,ny,r,c);
                }
            }
        }
        return sum;
    }
}