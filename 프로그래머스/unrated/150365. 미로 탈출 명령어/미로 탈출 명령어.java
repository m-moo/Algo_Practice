class Solution {
    int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    char[] dirChar = {'d','l','r','u'};
    int mapRow, mapCol, endRow, endCol;
    StringBuilder answer;
    String result;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        mapRow = n;
        mapCol = m;
        endRow = r;
        endCol = c;
        answer = new StringBuilder();

        int distance = distance(x,y,r,c);
        if(distance > k || (k-distance)%2 != 0) return "impossible";

        dfs(x,y,0,k);

        return result != null? result:"impossible";
    }

    public int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    public void dfs(int x, int y, int depth, int limit) {
        if(result != null) return;
        if(depth + distance(x,y,endRow,endCol) > limit) return;
        if(depth == limit) {
            if(x == endRow && y == endCol) {
                result = answer.toString();
            }
            return;
        }

        for(int i=0;i<dir.length;i++) {
            int nextX = x+dir[i][0];
            int nextY = y+dir[i][1];

            if(nextX > 0 && nextX <= mapRow && nextY > 0 && nextY <= mapCol) {
                answer.append(dirChar[i]);
                dfs(nextX,nextY,depth+1,limit);
                answer.deleteCharAt(answer.length()-1);
            }
        }
    }
}