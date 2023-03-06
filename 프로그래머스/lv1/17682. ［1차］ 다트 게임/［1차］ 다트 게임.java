import java.util.HashMap;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuffer number = new StringBuffer();
        int cnt = 0;
        for(int i=0;i<dartResult.length();i++) {
            char c = dartResult.charAt(i);
            if(c < '0'){
                if(c == '#') map.put(cnt-1,map.get(cnt-1)*-1);
                else if(c == '*'){
                    map.put(cnt-1,map.get(cnt-1)*2);
                    if(cnt-2 > -1) map.put(cnt-2,map.get(cnt-2)*2);
                }
            }else if(c > 'A'){
                map.put(cnt++,(int)Math.pow(Integer.parseInt(number.toString()),c=='D'?2:c=='T'?3:1));
                number.delete(0,number.length());
            }else {
                number.append(c);
            }
        }

        for(int i=0;i<cnt;i++) {
            answer+=map.get(i);
        }
        
        return answer;
    }
}