import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] p, int[] s) {
        List<Integer> answer = new ArrayList<>();

        int dep = 1;
        double days = Math.ceil((100-p[0])/(double)s[0]);
        for(int i=1;i<p.length;i++){
            double d = Math.ceil((100-p[i])/(double)s[i]);
            if(days >= d){
                dep++;
            }else{
                answer.add(dep);
                days = d;
                dep = 1;
            }
        }
        if(dep > 0)
            answer.add(dep);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}