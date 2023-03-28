class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int lastBit = n & -n;
        int diffBit = ((n ^ (n + lastBit)) / lastBit) >> 2;
        return n + lastBit | diffBit;
    }
}