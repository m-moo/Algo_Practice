class Solution {
    public int solution(int n) {
        int answer = n;
        
        int lastBit = n&(-n);
        answer += lastBit;
        int diff = Integer.bitCount(n) - Integer.bitCount(answer);

        for(int i=0;i<diff;i++) {
            answer+=Math.pow(2,i);
        }
        
        return answer;
    }
}