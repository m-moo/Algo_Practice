class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for(long x=0;x<=d;x+=k) {
            int y = (int)Math.sqrt(Math.pow(d,2) - Math.pow(x,2));
            answer += y/k;
            answer += 1; // y가 0인 경우
        }

        return answer;
    }
}