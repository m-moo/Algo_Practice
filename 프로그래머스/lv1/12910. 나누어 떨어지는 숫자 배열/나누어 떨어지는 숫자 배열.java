import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%divisor==0) lst.add(arr[i]);
        }
        
        if(lst.size()==0) answer = new int[]{-1};
        else {
            answer = lst.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(answer);
        }
        
        return answer;
    }
}