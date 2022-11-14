import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int p: priorities){
			pq.add(p);
		}

		while(!pq.isEmpty()){
			for(int i=0;i<priorities.length;i++){
				if(pq.peek() == priorities[i]){
					pq.poll();
					answer++;

					if(location == i) return answer;
				}
			}
		}
        return answer;
    }
}