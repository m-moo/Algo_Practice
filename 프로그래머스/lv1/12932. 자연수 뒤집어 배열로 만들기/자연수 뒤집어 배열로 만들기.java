class Solution {
    public int[] solution(long n) {   
        String num = Long.toString(n);
        int[] answer = new int[num.length()];
        int len = num.length();
        for(int i=0;i<len;i++){
            answer[i] = num.charAt(len-1-i) - '0';
        }
        return answer;
    }
}