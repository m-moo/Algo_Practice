class Solution {
    int answer = 0;
    public int solution(int[] nums) {
        backTrack(nums,0,0,0);

        return answer;
    }
    
    public void backTrack(int[] nums, int sum, int start, int depth) {
        for(int i=start;i<nums.length;i++) {
           if(depth == 2){
               int n = sum+nums[i];
               boolean isPrim = true;
                for(int j=2;j<=n/2;j++) {
                    if(n%j==0) {
                        isPrim = false;
                        break;
                    }
                }
                if(isPrim) answer++;
           }else{
               backTrack(nums, sum+nums[i], i+1, depth+1);
           }
        }
    }
}