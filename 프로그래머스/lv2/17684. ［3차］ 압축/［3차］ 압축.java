import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> dict = new HashMap<>();
        initDict(dict);
    
        int idx = 0;
        for(int s=0,e=0;e<msg.length();e++) {
            String w = msg.substring(s,e+1);

            if(dict.get(w) != null) idx = dict.get(w);
            else {
                dict.put(w,dict.size()+1);
                answer.add(idx);
                s=e;
                e--;
            }
            if(e == msg.length()-1) answer.add(idx);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    public void initDict(HashMap<String,Integer> dict) {
        for(int i='A';i<='Z';i++) {
            dict.put(String.valueOf((char)i),i-'A'+1);
        }
    }
}