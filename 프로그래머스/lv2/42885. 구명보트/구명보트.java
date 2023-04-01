import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<people.length;i++) {
            dq.add(people[i]);
        }

        int first = dq.peekFirst();
        while(dq.size() > 1) {
            if(dq.peekLast() <= limit - first) {
                dq.pollFirst();
                first = dq.peekFirst();
            }
            dq.pollLast();
            answer++;
        }
        if(!dq.isEmpty()) answer++;

        return answer;
    }
}