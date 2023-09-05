import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> del = new Stack<>();
        Stack<Integer> pick = new Stack<>();
        for(int i=0;i<n;i++) {
            del.add(deliveries[i]);
            pick.add(pickups[i]);
        }

        while(!del.isEmpty() || !pick.isEmpty()) {
            while(!del.isEmpty() && del.peek() == 0) {
                del.pop();
            }
            while(!pick.isEmpty() && pick.peek() == 0) {
                pick.pop();
            }
            answer += Math.max(del.size(),pick.size())*2;

            int boxes = cap;
            while(!del.isEmpty()) {
                int delCnt = del.pop();
                if(delCnt >= boxes) {
                    del.push(delCnt-boxes);
                    break;
                }else {
                    boxes -= delCnt;
                }
            }

            boxes = cap;
            while(!pick.isEmpty()) {
                int pickCnt = pick.pop();
                if(pickCnt >= boxes) {
                    pick.push(pickCnt-boxes);
                    break;
                }else {
                    boxes -= pickCnt;
                }
            }
        }
        return answer;
    }
}