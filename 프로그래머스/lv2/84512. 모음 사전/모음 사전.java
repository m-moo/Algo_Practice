class Solution {
    public int solution(String word) {
        String map = "AEIOU";
        int[] increase = {781, 156, 31, 6, 1};
        int answer = word.length();

        for(int i=0;i<word.length();i++){
            answer += increase[i] * map.indexOf(word.charAt(i));
        }
        return answer;
    }
}