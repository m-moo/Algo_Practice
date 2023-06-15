import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        if(k >= len) return len;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<len;i++) {
            pq.add(enemy[i]);
            if(i < k) continue;
            
            if(n - pq.peek() >= 0) {
                answer++;
                n -= pq.poll();
            }else break;
        }
        return answer+k;
    }
}