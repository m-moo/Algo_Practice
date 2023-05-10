import java.util.Stack;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] map = new char[m][n];
        for(int i=0;i<m;i++) map[i] = board[i].toCharArray();

        while(true) {
            int cnt = removeAndCountBlocks(m,n,map);
            if(cnt == 0) break;

            answer += cnt;
            dropBlocks(m,n,map);
        }
        return answer;
    }
    
    public int removeAndCountBlocks(int m, int n, char[][] map) {
        boolean[][] marked = new boolean[m][n];
        int cnt = 0;

        /* 해당되는 블럭 표시 */
        for(int i=0;i<m-1;i++) {
            for(int j=0;j<n-1;j++) {
                if(map[i][j] == 'X') continue;

                char target = map[i][j];
                if(map[i][j+1] == target && map[i+1][j] == target && map[i+1][j+1] == target) {
                    marked[i][j] = marked[i][j+1] = marked[i+1][j] = marked[i+1][j+1] = true;
                }
            }
        }
        /* 표시된 블럭 삭제 */
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(marked[i][j]) {map[i][j] = 'X'; cnt++;}
            }
        }
        return cnt;
    }

    public void dropBlocks(int m, int n, char[][] map) {
        for(int j=0;j<n;j++) {
            Stack<Character> st = new Stack<>();
            for(int i=0;i<m;i++) {
                if(map[i][j] != 'X') {
                    st.push(map[i][j]);
                    map[i][j] = 'X';
                }
            }
            for(int i=m-1;i>=0;i--) {
                if(!st.isEmpty()) map[i][j] = st.pop();
            }
        }
    }
}