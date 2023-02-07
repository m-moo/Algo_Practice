import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);
        }

        while(!pq.isEmpty()) {
            int curr = pq.poll();

            if(curr < K) {
                if(pq.size() == 0) {
                    return -1;
                }
                int next = pq.poll();
                int sum = curr+next*2;
                pq.offer(sum);
                answer++;
            }
        }
        return answer;
    }
}