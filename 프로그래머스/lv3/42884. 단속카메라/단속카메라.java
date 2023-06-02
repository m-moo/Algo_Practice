import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1],b[1]));
        int lastCam = Integer.MIN_VALUE;
        for(int[] r:routes) {
            if(lastCam < r[0]) {
                answer++;
                lastCam = r[1];
            }
        }
        return answer;
    }
}