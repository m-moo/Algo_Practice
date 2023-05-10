import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> st = new Stack<>();

        for(int i=0;i< numbers.length;i++) {
            while(!st.isEmpty() && numbers[st.peek()] < numbers[i]) {
                answer[st.pop()] = numbers[i];
            }
            st.push(i);
        }

        while(!st.isEmpty()) answer[st.pop()] = -1;
        return answer;
    }
}