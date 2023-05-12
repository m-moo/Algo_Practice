class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] map = {"4","1","2"};

        while(n > 0) {
            answer.append(map[n%3]);
            n = (n-1)/3;

        }
        answer.reverse();
        return answer.toString();
    }
}