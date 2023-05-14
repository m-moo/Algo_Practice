import java.util.Stack;

class Solution {
    public String solution(String p) {
        if(p.isEmpty()) return p;
        String u = "", v = "";
        int cnt = 0;
        /* split */
        for(int i=0;i<p.length();i++) {
            if(p.charAt(i) == '(') cnt++;
            else cnt--;

            if(cnt == 0) {
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }

        if(!isCorrect(u)) {
            v = solution(v);
            String tmp = "("+v+")";
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<u.length()-1;i++) {
                char c = u.charAt(i);
                sb.append(c=='('?')':'(');
            }
            return tmp+sb.toString();
        }else v = solution(v);

        return u+v;
    }
    
    public boolean isCorrect(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') st.push(c);
            else {
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        return true;
    }
}