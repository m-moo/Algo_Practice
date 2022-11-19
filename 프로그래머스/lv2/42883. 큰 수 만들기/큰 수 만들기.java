import java.util.stream.Stream;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length()-k;
        int start = 0;
        int tmp_start = 0;

        for(int i=0;i<len;i++){
            int max = 0;
            for(int j=start;j<=i+k;j++){
                int n = number.charAt(j)-'0';
                if(max < n){
                    tmp_start = j;
                    max = n;
                }
            }
            answer.append(max);
            start = tmp_start+1;
        }
        return answer.toString();
    }
}