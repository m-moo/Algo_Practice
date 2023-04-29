import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++) {
            int cnt = 0, curr = i;
            Stack<Character> st = new Stack<>();
            while(cnt < s.length()) {
                char c = arr[curr];
                if(c == ']' || c == '}' || c == ')') {
                    if(cnt == 0 || st.isEmpty()) {st.push(c); break;}
                    if(st.peek()+2 == c || st.peek()+1 == c) st.pop();
                }else st.push(c);

                if(++curr == s.length()) curr = 0;
                cnt++;
            }
            if(st.isEmpty()) answer++;
        }
        
        return answer;
    }
}