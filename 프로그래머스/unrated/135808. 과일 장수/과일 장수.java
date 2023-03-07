import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int[] box = new int[m];
        int cnt = 0;
        int min = k;
        for(int i=score.length-1;i>-1;i--) {
            box[cnt] = score[i];
            min = Math.min(min,score[i]);
            cnt++;
            if(cnt==m) {
                answer+=min*m;
                box = new int[m];
                cnt = 0;
            }
        }
        
        return answer;
    }
}