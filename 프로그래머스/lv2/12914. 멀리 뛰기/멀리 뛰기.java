class Solution {
    public long solution(int n) {
        if(n < 4) return n;
        
        long curr = 0;
        long pprev = 2;
        long prev = 3;
        for(int i=4;i<=n;i++) {
            curr = (pprev+prev)%1234567;
            pprev = prev;
            prev = curr;
        }
        
        return curr;
    }
}