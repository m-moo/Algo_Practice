class Solution {
    int max = 0;
    int[] info;
    int[][] edges;
    boolean[] visited;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        this.visited = new boolean[info.length];
        visited[0] = true;
        dfs(1,0);
        return max;
    }
    
    public void dfs(int sheep, int wolf) {
        if (sheep > wolf) max = Math.max(max, sheep);
        else return;

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (visited[parent] && !visited[child]) {
                visited[child] = true;
                if (info[child] == 0) {
                    dfs(sheep + 1, wolf);
                } else {
                    dfs(sheep, wolf + 1);
                }
                visited[child] = false;
            }
        }
    }
}