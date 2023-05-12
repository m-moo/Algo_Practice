import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<>();

        int cnt = 1;
        int idx = 0;
        while(cnt <= order.length+1 && idx < order.length) {
            if(cnt == order[idx]) {
                answer++;
                idx++;
                cnt++;
            }else {
                if(!st.isEmpty() && st.peek() == order[idx]) {
                    answer++;
                    idx++;
                    st.pop();
                }else st.push(cnt++);
            }
        }
        return answer;
    }
}