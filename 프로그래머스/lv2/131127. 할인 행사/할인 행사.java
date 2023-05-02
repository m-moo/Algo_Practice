import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++) {
           map.put(want[i], number[i]);
        }

        for(int i=0;i<=discount.length-10;i++) {
            HashMap<String, Integer> wantMap = new HashMap<>(map);
            int j=i;
            for(;j<i+10;j++) {
                String item = discount[j];
                if(wantMap.get(item) == null || wantMap.get(item) < 1) break;
                else wantMap.put(item,wantMap.get(item)-1);
            }
            if(j==i+10) answer++;
        }
        return answer;
    }
}