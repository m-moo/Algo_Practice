class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++) {
            int rs = getDivisor(i);
            if(rs%2==0) answer+=i;
            else answer-=i;
        }
        
        return answer;
    }
    
    public int getDivisor(int n) {
        int cnt = 0;
        for(int i=1;i<=n/2;i++){
            if(n%i==0) cnt++;
        }
        return ++cnt;
    }
}