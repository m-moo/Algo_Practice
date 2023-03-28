class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        String removed = s;
        while(!s.equals("1")) {
            removed = s.replaceAll("0","");
            answer[1] += s.length() - removed.length();
            s = Integer.toBinaryString(removed.length());

            answer[0]++;
        }
        
        return answer;
    }
}