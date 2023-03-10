import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        StringBuffer answer = new StringBuffer();

        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        int lastIdx = y.length-1;
        for(int i=x.length-1;i>-1;i--) {
            char c = x[i];
            for(int j=lastIdx;j>-1;j--) {
                if(c == y[j]) {
                    lastIdx = j-1;
                    answer.append(c);
                    break;
                }
            }
        }
        if(answer.length() == 0) return "-1";
        else if(answer.charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}