import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] nums = Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).toArray();

        for(int i=0;i<nums.length;i++){
            answer+=nums[i];
        }
        
        return answer;
    }
}