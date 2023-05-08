class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String kBase = convertToBaseK(n,k);
        String[] splited = kBase.split("0");

        for(String num:splited) {
            if(!num.isEmpty() && isPrime(Long.parseLong(num))){
                answer++;
            }
        }
        return answer;
    }
    
    public String convertToBaseK(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%k);
            n/=k;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long num) {
        if(num<2) return false;

        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}