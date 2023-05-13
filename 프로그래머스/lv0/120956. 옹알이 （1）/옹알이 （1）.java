import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        String[] canDo = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(int i=0;i<babbling.length;i++) {
            String babble = babbling[i];
            for(int j=0;j<canDo.length;j++) {
                babble = babble.replace(canDo[j],"0");
            }
            babble = babble.replaceAll("0","");
            if(babble.isEmpty()) answer++;
        }
        
        return answer;
    }
}