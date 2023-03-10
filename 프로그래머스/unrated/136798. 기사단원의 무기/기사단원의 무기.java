class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;

        for(int i=2;i<=number;i++) {
            int div = getDiv(i);
            if(div>limit) answer+=power;
            else answer+=div;
        }
        return answer;
    }
    public int getDiv(int n){
        int rs = 2;
        for(int i=2;i<=n/2;i++) {
            if(n%i==0) rs++;
        }
        return rs;
    }
}