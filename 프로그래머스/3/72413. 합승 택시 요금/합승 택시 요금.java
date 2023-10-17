class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n+1][n+1];
        int max = Integer.MAX_VALUE;

        // 배열 초기화
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                cost[i][j] = i==j?0:max;
            }
        }
        // 간선 정보 적용
        for(int[] fare:fares) {
            int to = fare[0], from= fare[1], fee = fare[2];
            cost[to][from] = fee;
            cost[from][to] = fee;
        }
        // 플로이드 와샬 적용
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                if(cost[i][k] == max) continue;
                for(int j=1;j<=n;j++) {
                    if(cost[k][j] == max) continue;
                    cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
                }
            }
        }
        // 최소 비용 계산
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++) {
            answer = Math.min(answer, cost[i][s]+cost[i][a]+cost[i][b]);
        }
        return answer;
    }
}