import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
       int answer = 0;
        Arrays.sort(d);

        int cnt = 0, sum = 0;
        while(cnt < d.length) {
            sum+=d[cnt];
            if(sum <= budget) {
                answer++;
            }else {
                break;
            }
            cnt++;
        }
        return answer;
    }
}