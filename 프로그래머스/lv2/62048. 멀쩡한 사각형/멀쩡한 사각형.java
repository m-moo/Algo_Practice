class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h;

        int gcd = 1;
        for(int i=1;i<=Math.min(w,h);i++) {
            if(w%i==0 && h%i==0) gcd = i;
        }
        
        return answer - (((w/gcd) + (h/gcd) - 1)*gcd);
    }
}