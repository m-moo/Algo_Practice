import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int w:works) pq.add(w);

        while(n!=0) {
            int num = pq.poll()-1;
            pq.add(num<0?0:num);
            n--;
        }
        
        for(Integer num:pq) answer += (long)num*num;

        return answer;
    }
}