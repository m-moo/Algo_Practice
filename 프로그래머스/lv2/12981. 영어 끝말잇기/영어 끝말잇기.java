import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
       int[] answer = new int[2];

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put(words[0],1);
        int i=1;
        for(;i<words.length;i++) {
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) break;
            if(hm.get(words[i]) != null) break;
            hm.put(words[i],1);
        }
        if(i < words.length) {
            answer[0] = i%n + 1;
            answer[1] = i/n + 1;
        }

        return answer;
    }
}