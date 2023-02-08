import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        /* 요청시간 오름차순 정렬 */
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        /* 처리시간 오름차순 정렬 우선순위 큐 */
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);

        int cnt = 0;
        int current = 0;
        int jobIdx = 0;
        while(cnt < jobs.length) {
            /* 현재 시점까지 들어온 요청 큐에 넣음*/
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= current) {
                pq.add(jobs[jobIdx++]);
            }

            if(pq.isEmpty()) {
                current = jobs[jobIdx][0];
            }else{
                int[] top = pq.poll();
                answer += top[1]+(current-top[0]);
                current += top[1];
                cnt++;
            }
        }

        return answer /= jobs.length;
    }
}