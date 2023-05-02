import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("[{}]","");
        String[] arr = s.split(",");
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int n = Integer.parseInt(arr[i]);
            map.put(n,map.getOrDefault(n,0)+1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));


        int[] answer = new int[keys.size()];
        for(int i=0;i<keys.size();i++) {
            answer[i] = keys.get(i);
        }
        
        return answer;
    }
}