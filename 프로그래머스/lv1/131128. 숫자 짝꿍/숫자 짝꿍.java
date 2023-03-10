import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        StringBuffer answer = new StringBuffer();

        int[] x = new int[10];
        int[] y = new int[10];
        for(int i=0;i<X.length();i++) {
            x[X.charAt(i)-'0']++;
        }
        for(int i=0;i<Y.length();i++) {
            y[Y.charAt(i)-'0']++;
        }

        for(int i=9;i>-1;i--) {
            if(x[i] > 0 && y[i] > 0) {
                for(int j=0;j<Math.min(x[i],y[i]);j++) {
                    answer.append(i);
                }
            }
        }
        if(answer.length() == 0) return "-1";
        else if(answer.charAt(0) == '0') return "0";
        
        return answer.toString();
    }
}