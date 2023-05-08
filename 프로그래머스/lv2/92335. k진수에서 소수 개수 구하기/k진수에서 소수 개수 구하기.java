class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] kBased = Integer.toString(n,k).split("0");
        for(String num:kBased) {
            if(!num.isEmpty() && isPrime(Long.parseLong(num))){
                answer++;
            }
        }
        return answer;
    }
    public boolean isPrime(long num) {
        if(num<2) return false;

        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}