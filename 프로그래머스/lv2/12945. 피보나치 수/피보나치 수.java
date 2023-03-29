class Solution {
    public int solution(int n) {
        long answer = 1, prev = 0;
        for(long i=2;i<=n;i++) {
            long tmp = prev;
            prev = answer;
            answer += tmp;
            answer%=1234567;
        }
        return (int)answer;
    }
}