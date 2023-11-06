class Solution {
    public long solution(int[] sequence) {
        long answer;
        int len = sequence.length;

        long[] a = new long[len];
        long[] b = new long[len];
        long bool = -1;
        for(int i=0;i<len;i++) {
            a[i] = sequence[i] * bool;
            bool *= -1;
            b[i] = sequence[i] * bool;
        }
        
        answer = Math.max(a[0], b[0]);
        for(int i=1;i<len;i++) {
            a[i] = Math.max(a[i-1]+a[i], a[i]);
            b[i] = Math.max(b[i-1]+b[i], b[i]);
            
            long max = Math.max(a[i],b[i]);
            answer = Math.max(answer, max);
        }
        return answer;
    }
}