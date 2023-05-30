class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        char[] nums = String.valueOf(storey).toCharArray();
        int up = 0;
        for(int i=0;i<nums.length;i++) {
            int curr = nums[(nums.length-1-i)] - '0';
            int next = i<nums.length-1?nums[(nums.length-2-i)] - '0':0;
            curr+=up;

            if(curr > 5 || curr==5 && next+1 > 5) {
                curr = 10-curr;
                up = 1;
            }else up = 0;

            answer += curr;
        }
        
        return answer+=up;
    }
}