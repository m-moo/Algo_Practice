import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
       Stack<Integer> st = new Stack<>();
        int idx = 0;
        for(int i=0;i<ingredient.length;i++) {
            st.add(ingredient[i]);
            if(st.size() > 3) {
                if(st.peek() == 1 && st.get(idx-1) == 3
                        && st.get(idx-2) == 2 && st.get(idx-3) == 1) {
                    answer++;
                    int limit = idx-4;
                    while(idx != limit) {
                        st.pop();
                        idx--;
                    }
                }
            }
            idx++;
        }
        
        return answer;
    }
}