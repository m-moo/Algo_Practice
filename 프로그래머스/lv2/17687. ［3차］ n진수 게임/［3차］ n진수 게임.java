class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int cnt = 0;
        StringBuilder sb =  new StringBuilder();
        while(sb.length() <= t*m+p) {
            sb.append(Integer.toString(cnt++,n));
        }
        
        String seq = sb.toString();
        for(int i=0;i<t;i++) {
            answer.append(seq.charAt(p-1+i*m));
        }

        return answer.toString().toUpperCase();
    }
}