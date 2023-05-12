import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int len = queue1.length;
        long sum1 = 0, sum2 = 0;
        for(int i=0;i< queue1.length;i++) {
            sum1 += queue1[i]; q1.add(queue1[i]);
            sum2 += queue2[i]; q2.add(queue2[i]);
        }

        long tot = sum1+sum2;
       if(tot % 2 != 0) return -1;
        
        tot /= 2;
        int i = 0,j =0;
        while(i <= len*2 && j <= len*2) {
            if(sum1 == tot) return i+j;
            if(sum1 < tot) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
                i++;
            }
            else {
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.add(q1.poll());
                j++;
            }
        }
        return -1;
    }
}