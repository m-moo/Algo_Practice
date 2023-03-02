import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        /* 스테이지 실패 매핑 */
        HashMap<Integer,Double> map = new HashMap<>();
        long stack = 0;
        for(int i=0;i<stages.length;i++) {
            int stage = stages[i];
            if(stage<=N) map.put(stage-1,map.getOrDefault(stage-1,0.0)+1);
            else stack++;
        }
        /* 스테이지 실패율 계산 */
        for(int i=N-1;i>-1;i--) {
            if(map.get(i)==null) map.put(i,0.0);
            else{
                double n = map.get(i);
                if(n!=0){
                    stack+=n;
                    map.put(i, n/stack);
                }
            }
        }
        /* 순위 정렬 */
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1) == map.get(o2)) return 1;
                else return map.get(o2).compareTo(map.get(o1));
            }
        });

        for(int i=0;i< answer.length;i++) {
            answer[i] = keys.get(i)+1;
        }
        return answer;
    }
}