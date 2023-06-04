import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        int kind = new HashSet<>(Arrays.asList(gems)).size();
        HashMap<String,Integer> stoneMap = new HashMap<>();

        int start = 0, max = Integer.MAX_VALUE;
        for(int end=0;end<gems.length;end++) {
            stoneMap.put(gems[end],stoneMap.getOrDefault(gems[end],0)+1);

            while(stoneMap.get(gems[start]) > 1) {
                stoneMap.put(gems[start],stoneMap.get(gems[start++])-1);
            }

            if(stoneMap.size() == kind && max > end-start) {
                max = end-start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
        return answer;
    }
}