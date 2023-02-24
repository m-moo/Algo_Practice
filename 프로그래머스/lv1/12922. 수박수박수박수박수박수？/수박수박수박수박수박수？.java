class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();

        int cnt = n/2;
        for(int i=0;i<cnt;i++) {
            sb.append("수박");
        }
        if(n%2!=0) sb.append("수");
        
        return sb.toString();
    }
}