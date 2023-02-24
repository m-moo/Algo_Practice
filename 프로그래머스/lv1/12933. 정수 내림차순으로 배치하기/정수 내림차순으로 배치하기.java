import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String num = Long.toString(n);
        char[] nums = num.toCharArray();
        Arrays.sort(nums);

        for(int i=nums.length-1;i>-1;i--) {
            answer += (nums[i]-'0')*Math.pow(10,i);
        }
        
        return answer;
    }
}