class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = (int)(Math.sqrt(n)*10)%10==0?1:2;
        
        return answer;
    }
}