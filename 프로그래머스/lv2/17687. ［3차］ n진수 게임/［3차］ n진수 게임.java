class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;

        StringBuilder sb =  new StringBuilder();
        while(sb.length() <= t*m+p) {
            sb.append(Integer.toString(cnt,n).toUpperCase());
            cnt++;
        }

        cnt = p-1;
        String seq = sb.toString();
        while(answer.length() < t) {
            answer.append(seq.charAt(cnt));
            cnt+=m;
        }

        return answer.toString();
    }
}