import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> count = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<cards.length;i++) {
            if(!visited[i]) {
                int cnt = 1;
                visited[i] = true;
                int n = cards[i]-1;
                while(n != i) {
                    visited[n] = true;
                    n  = cards[n]-1;
                    cnt++;
                }
                count.add(cnt);
            }
        }
        if(count.size() < 2) return 0;
        else return count.poll()*count.poll();
    }
}