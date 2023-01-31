class Solution {
    int answer = -1;
    int[][] dg;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dg = dungeons;
        backTrack(k,0);
        
        return answer;
    }
    
    public void backTrack(int k,int depth) {
        for(int i=0;i<dg.length;i++){
            if(!visited[i] && dg[i][0]<=k){
                visited[i] = true;
                backTrack(k-dg[i][1],depth+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}