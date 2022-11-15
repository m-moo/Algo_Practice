import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> s = new Stack<>();

        s.push(0);
        for(int i=1;i<len;i++){
            while(!s.isEmpty()&&prices[s.peek()]>prices[i]){
                answer[s.peek()] = i-s.peek();
                s.pop();
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            answer[s.peek()] = len-s.peek()-1;
            s.pop();
        }

        return answer;
    }
}