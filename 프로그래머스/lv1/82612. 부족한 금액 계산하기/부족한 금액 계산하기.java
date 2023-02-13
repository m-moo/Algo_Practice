class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long tot = price;
        for(int i=2;i<=count;i++){
            tot += price*i;
        }
        answer = tot-money;

        return answer<0?0:answer;
    }
}