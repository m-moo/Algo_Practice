import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n+1][n+1];
        int max = 100_000_000;

        // 배열 초기화
        for(int i=0;i<=n;i++) {
            Arrays.fill(cost[i], max);
            cost[i][i] = 0;
        }
        // 간선 정보 적용
        for(int[] fare:fares) {
            int to = fare[0], from= fare[1], fee = fare[2];
            cost[to][from] = cost[from][to] = fee;
        }
        // 플로이드 와샬 적용
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
                }
            }
        }
        // 최소 비용 계산
        int answer = cost[s][a] + cost[s][b];
        for(int i=1;i<=n;i++) {
            answer = Math.min(answer, cost[i][s]+cost[i][a]+cost[i][b]);
        }
        return answer;
    }
}