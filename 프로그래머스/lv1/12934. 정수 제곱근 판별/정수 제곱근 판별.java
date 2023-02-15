class Solution {
    public long solution(long n) {
        long answer = 0;
        double tmp  = Math.sqrt(n);
        if(tmp%1==0) answer = (long)Math.pow(tmp+1,2);
        else return -1;
        return answer;
    }
}