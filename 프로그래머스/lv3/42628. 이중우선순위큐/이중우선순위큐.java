import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rq = new PriorityQueue<>();

         for(int i=0;i< operations.length;i++) {
            String[] op = operations[i].split(" ");
            int n = Integer.parseInt(op[1]);
            if(op[0].equals("I")){
                /* 숫자 삽입 */
                pq.add(n);
            }else{
                if(!pq.isEmpty()) {
                    /* 삭제 값 분기 */
                    if(n>0){
                        pq.remove();
                    }else{
                        rq.addAll(pq);
                        rq.remove();
                        pq.clear();
                        pq.addAll(rq);
                        rq.clear();
                    }
                }
            }
        }
        if(!pq.isEmpty()){
            rq.clear();
            rq.addAll(pq);
            answer[0] = pq.poll();
            answer[1] = rq.poll();
        }
        return answer;
    }
}