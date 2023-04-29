import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++) {
            int t = tangerine[i];
            map.put(t, map.getOrDefault(t,0)+1);
        }
        
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());

        for(Integer v:values) {
            k -= v;
            answer++;
            if(k <= 0) break;
        }
        
        return answer;
    }
}