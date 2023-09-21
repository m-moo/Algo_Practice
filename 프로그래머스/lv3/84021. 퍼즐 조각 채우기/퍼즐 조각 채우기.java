import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Solution {
    int n;
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    boolean[][] visited;
    
    public int solution(int[][] game_board, int[][] table) {
        n = table.length;
        visited = new boolean[n][n];

        List<List<int[]>> blocks = new ArrayList<>();
        List<List<int[]>> spaces = new ArrayList<>();

        // 모양 파악
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && table[i][j] != 0) {
                    List<int[]> block = new ArrayList<>();
                    block.add(new int[]{i, j});
                    visited[i][j] = true;
                    dfs(table, i, j, block, true);
                    block = normalize(block);
                    blocks.add(block);
                }
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && game_board[i][j] != 1) {
                    List<int[]> space = new ArrayList<>();
                    space.add(new int[]{i, j});
                    visited[i][j] = true;
                    dfs(game_board, i, j, space, false);
                    space = normalize(space);
                    spaces.add(space);
                }
            }
        }

        int answer = 0;
        // 회전하면서 매칭
        for (List<int[]> space : spaces) {
            boolean matched = false;
            for (Iterator<List<int[]>> it = blocks.iterator(); it.hasNext() && !matched; ) {
                List<int[]> block = it.next();
                if (space.size() != block.size()) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    if (match(space, block)) {
                        answer += block.size();
                        it.remove();
                        matched = true;
                        break;
                    }
                    block = rotate(block);
                }
            }
        }
        return answer;
    }
    
    public void dfs(int[][] map, int x, int y, List<int[]> history, boolean type) {
        int check = type ? 1 : 0;
        for (int[] d : dir) {
            int nextX = x + d[0], nextY = y + d[1];
            if (nextX > -1 && nextY > -1 &&
                nextX < n && nextY < n) {
                if (!visited[nextX][nextY] && map[nextX][nextY] == check) {
                    visited[nextX][nextY] = true;
                    history.add(new int[]{nextX, nextY});
                    dfs(map, nextX, nextY, history, type);
                }
            }
        }
    }

    public boolean match(List<int[]> space, List<int[]> block) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        };
        Collections.sort(space, comparator);
        Collections.sort(block, comparator);

        for (int i = 0; i < space.size(); i++) {
            if (!Arrays.equals(space.get(i), block.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<int[]> rotate(List<int[]> block) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] point : block) {
            rotated.add(new int[]{point[1], -point[0]}); // {x,y}의 90도 회전 {-y,x}
        }
        return normalize(rotated);
    }

    public List<int[]> normalize(List<int[]> block) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] point : block) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }

        List<int[]> normalized = new ArrayList<>();
        for (int[] point : block) {
            normalized.add(new int[]{point[0] - minX, point[1] - minY});
        }
        return normalized;
    }
}