class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<signs.length;i++) {
            int n = signs[i]?absolutes[i]:-absolutes[i];
            answer += n;
        }
        return answer;
    }
}