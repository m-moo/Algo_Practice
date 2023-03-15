import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> alphabet = new ArrayList<>();
        char[] skipArr = skip.toCharArray();
        Arrays.sort(skipArr);

        int skipIdx = 0;
        for(int i='a';i<='z';i++) {
            if(i != skipArr[skipIdx]) alphabet.add((char)i);
            else {
                if(skipIdx != skipArr.length-1) skipIdx++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int mvIdx = alphabet.indexOf(c)+index;

            while(mvIdx >= alphabet.size()) {
                mvIdx-=alphabet.size();
            }
            c = alphabet.get(mvIdx);

            sb.append(c);
        }
        
        
        return sb.toString();
    }
}