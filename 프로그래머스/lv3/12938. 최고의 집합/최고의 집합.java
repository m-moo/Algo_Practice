class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int rs = s/n;
        if(rs == 0) return new int[]{-1};

        int rest = s%n;
        for(int i=n-1;i>-1;i--) {
            answer[i] = rs;
            if(rest != 0) {answer[i]++; rest--;}
        }
        
        return answer;
    }
}