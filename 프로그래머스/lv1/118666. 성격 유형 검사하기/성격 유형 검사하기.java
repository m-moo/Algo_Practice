import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        /* R,T / C,F / J,M / A,N */
        char[][] stand = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<survey.length;i++) {
            int n = choices[i];
            char[] cArr = survey[i].toCharArray();
            if(n > 4){
                map.put(cArr[1],map.getOrDefault(cArr[1],0)+(n-4));
            }else if(n < 4){
                map.put(cArr[0],map.getOrDefault(cArr[0],0)+(4-n));
            }
        }

        for(int i=0;i<stand.length;i++) {
            int l = map.getOrDefault(stand[i][0],0), r = map.getOrDefault(stand[i][1],0);
            if(l < r){
                answer+=stand[i][1];
            }else if(l > r){
                answer+=stand[i][0];
            }else{
                if (stand[i][0] > stand[i][1]) answer+=stand[i][1];
                else answer+=stand[i][0];
            }
        }
        return answer;
    }
}