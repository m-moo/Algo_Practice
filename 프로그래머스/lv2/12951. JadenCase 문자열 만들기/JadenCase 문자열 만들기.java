class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char[] arr = s.toCharArray();
        int cnt = 0;
        for(int i=0;i<arr.length;i++) {
            char c = arr[i];
            if(cnt==0 && c > '9') {
                c = Character.toUpperCase(c);
                cnt++;
            }else if(c == ' '){
                cnt = 0;
            }else {
                c = Character.toLowerCase(c);
                cnt++;
            }
            answer.append(c);
        }
        return answer.toString();
    }
}