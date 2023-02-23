class Solution {
    int answer = 0;
    String[] canSay = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
       for(int i=0;i<babbling.length;i++){
            StringBuffer b = new StringBuffer(babbling[i]);
            getBab(b, "");
        }
        
        return answer;
    }
    
    public void getBab(StringBuffer b, String last) {
        String before = b.toString();
        /* 순회 하면서 발음 가능 찾기*/
        for(int i=0;i<canSay.length;i++) {
            if(b.length()!=0){
                int start = b.indexOf(canSay[i]);
                if(start == 0) {
                    /* 이전 발음과 같으면 불허 */
                    if(!last.equals(canSay[i])) {
                        int len = canSay[i].length();
                        b.delete(start, start+len);
                        last = canSay[i];
                    }
                }
            }
        }
        /*다 발음하지 않은 경우 다시 찾음 */
        if(b.length() == 0) answer++;
        else {
            if(!before.equals(b.toString())) getBab(b, last);
        }
    }
}