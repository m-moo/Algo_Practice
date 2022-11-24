import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;
        int answer = 0;

        for(int t:truck_weights) {
            while(true) {
                // 트럭이 다리 끝에 다다랐을 경우 트럭과 트럭의 무게를 뺌
                if(bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                }else{
                    // 트럭이 최대 무게 초과
                    if(sum+t > weight) {
                        bridge.offer(0);
                        answer++;
                    }else{
                        // 트럭이 최대 무게 이내
                        bridge.offer(t);
                        sum+=t;
                        answer++;
                        break;
                    }
                }
            }
        }
        // 걸린 시간 + 마지막 트럭의 통과 시간(다리의 길이)
       return answer+bridge_length;
    }
}