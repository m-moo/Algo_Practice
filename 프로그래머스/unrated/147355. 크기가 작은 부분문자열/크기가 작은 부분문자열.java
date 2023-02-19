class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long pNum = Long.parseLong(p);
        for(int i=0;i<=t.length()-len;i++) {
            long n = Long.parseLong(t.substring(i,i+len));
            if(n <= pNum) answer++;
        }
        
        return answer;
    }
}