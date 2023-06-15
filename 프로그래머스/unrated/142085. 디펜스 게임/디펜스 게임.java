import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        if(k >= len) return len;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0;
        while(idx < len) {
            pq.add(enemy[idx++]);
            if(idx <= k) continue;
            if(n - pq.peek() >= 0) {
                answer++;
                n -= pq.poll();
            }else break;
        }
        return answer+k;
    }
}