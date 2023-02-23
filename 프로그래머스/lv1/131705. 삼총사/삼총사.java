class Solution {
    int answer = 0;
    boolean[] visited;   
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        dfs(number,0,0,0);
        return answer;
    }
    
    public void dfs(int[] number, int sum, int start, int depth) {
        if(depth < 3) {
            for(int i=start;i<number.length;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    int tot = sum+number[i];
                    if(depth == 2 && tot ==0) answer++;
                    else dfs(number, tot,i+1, depth+1);

                    visited[i] = false;
                }
            }
        }
    }
}