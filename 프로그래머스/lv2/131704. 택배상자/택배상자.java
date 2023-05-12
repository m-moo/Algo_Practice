import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;

        Stack<Integer> subLine = new Stack<>();
        for(int i=1;i<= order.length;i++) {
            subLine.push(i);

            while(!subLine.isEmpty()) {
                if(subLine.peek() == order[cnt]) {
                    subLine.pop();
                    answer++; cnt++;
                }else break;
            }
        }
        return answer;
    }
}