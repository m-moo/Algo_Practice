class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuffer sb = new StringBuffer(s);
        char start = sb.charAt(0);
        int diff = 0;

        for(int i=0;i<sb.length();i++) {
            if (start != sb.charAt(i)) diff--;
            else diff++;

            if (diff == 0) {
                answer++;
                sb.delete(0, i + 1);
                i = 0;
                diff = 1;
                if(sb.length() > 0) start = sb.charAt(0);
            }
            if(i==sb.length()-1) answer++;
        }
        
        return answer;
    }
}