class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        /* 첫번째 줄 셋팅 */
        for(int i=0;i<4;i++) dp[0][i] = land[0][i];
        
        for(int i=1;i<land.length;i++) {
            for(int j=0;j<4;j++) {/* 현재 row의 col */
                int max = -1;
                for(int k=0;k<4;k++) { /* 이전 row의 col */
                    if(j==k) continue;
                    
                    max = Math.max(max,dp[i-1][k]);
                }
                /* 이전 row의 최대값과 현재 row,col의 합 */
                dp[i][j] = max+land[i][j];
            }
        }
        
        for(int i=0;i<4;i++) answer = Math.max(answer,dp[land.length-1][i]);
        
        return answer;
    }
    
}