import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int cover = w*2+1;
        int curr = 1;
        int idx = 0;

        while(curr <= n) {
            if(idx >= stations.length || curr < stations[idx] - w) {
                curr += cover;
                answer++;
            }else {
                curr = stations[idx++]+w+1;
            }
        }
        return answer;
    }
}