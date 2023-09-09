import java.util.ArrayList;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] map = new int[rows+1][columns+1];

        for(int i=0;i<queries.length;i++) {
            int sX = queries[i][0], sY = queries[i][1];
            int eX = queries[i][2], eY = queries[i][3];

            int currX = sX, currY = sY;
            int prev = map[currX][currY];
            if(prev == 0) prev = ((currX-1) * columns + currY);
            int min = prev;

            /* 우향 */
            for(int k=0;k<eY-sY;k++) {
                int curr = map[currX][++currY];
                if(curr == 0) curr =  ((currX-1) * columns + currY);
                min = Math.min(min,curr);
                map[currX][currY] = prev;
                prev = curr;
            }
            /* 하향 */
            for(int k=0;k<eX-sX;k++) {
                int curr = map[++currX][currY];
                if(curr == 0) curr =  ((currX-1) * columns + currY);
                min = Math.min(min,curr);
                map[currX][currY] = prev;
                prev = curr;
            }
            /* 좌향 */
            for(int k=0;k<eY-sY;k++) {
                int curr = map[currX][--currY];
                if(curr == 0) curr =  ((currX-1) * columns + currY);
                min = Math.min(min,curr);
                map[currX][currY] = prev;
                prev = curr;
            }
            /* 상향 */
            for(int k=0;k<eX-sX;k++) {
                int curr = map[--currX][currY];
                if(curr == 0) curr =  ((currX-1) * columns + currY);
                min = Math.min(min,curr);
                map[currX][currY] = prev;
                prev = curr;
            }
            answer.add(min);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}