import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        HashMap<Double,Integer> torqueMap = new HashMap<>();

        for(int weight:weights) {
            double w = weight*1.0;
            double[] calc = new double[]{ w, w*2.0/3.0, w*2.0/4.0, w*3.0/4.0};

            if(torqueMap.containsKey(calc[0])) answer += torqueMap.get(calc[0]);
            if(torqueMap.containsKey(calc[1])) answer += torqueMap.get(calc[1]);
            if(torqueMap.containsKey(calc[2])) answer += torqueMap.get(calc[2]);
            if(torqueMap.containsKey(calc[3])) answer += torqueMap.get(calc[3]);

            torqueMap.put(w, torqueMap.getOrDefault(w,0)+1);
        }

        return answer;
    }
}