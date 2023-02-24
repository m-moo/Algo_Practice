class Solution {
    public String solution(String s) {
        String answer = "";
        
        int len = s.length();
        int idx = len/2;
        if(len%2==0){
            answer = s.substring(idx-1,idx+1);
        }else {
            answer = s.substring(idx,idx+1);
        }
        
        return answer;
    }
}