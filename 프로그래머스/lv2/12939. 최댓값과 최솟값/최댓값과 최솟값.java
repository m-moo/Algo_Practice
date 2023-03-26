import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int min = 100000, max = -100000;
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++) {
            int n = Integer.parseInt(arr[i]);
            
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        return min+" "+max;
    }
}