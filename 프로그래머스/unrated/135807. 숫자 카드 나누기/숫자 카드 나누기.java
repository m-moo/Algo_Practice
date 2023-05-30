class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcdA = arrayA[0], gcdB = arrayB[0];
        for(int i=1;i<arrayA.length;i++) {
            gcdA = gcd(gcdA,arrayA[i]);
            gcdB = gcd(gcdB,arrayB[i]);
        }

        for(int i=0;i<arrayA.length;i++) {
            if(gcdA!=0 && arrayB[i]%gcdA == 0) gcdA = 0;
            if(gcdB!=0 && arrayA[i]%gcdB == 0) gcdB = 0;
        }

        answer = Math.max(gcdA,gcdB);
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(a%b == 0) return b;
        return gcd(b,a%b);
    }
}