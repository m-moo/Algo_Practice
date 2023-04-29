class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        for(int i=0;i<answer.length;i++) {
            long r = (left+i)/n;
            long c = (left+i)%n;
            
            answer[i] = (int)(Math.max(r,c)+1); 
        }
        return answer;
    }
}