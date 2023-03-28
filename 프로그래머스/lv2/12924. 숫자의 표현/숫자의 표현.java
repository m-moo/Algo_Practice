class Solution {
    public int solution(int n) {
        int answer = 1;

        for(int i=1;i<=n/2;i++) {
            int tot = 0;
            int num = i;
            while(tot < n) {
                tot+=num;
                if(tot==n) answer++;
                num++;
            }
        }
        return answer;
    }
}