import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
       return new StringBuffer(new String(arr)).reverse().toString();
    }
}