class Solution {
    public String solution(String phone_number) {
        
        StringBuffer sb = new StringBuffer();
        int len = phone_number.length();
        for(int i=0;i<len;i++) {
            if(i >= len-4) sb.append(phone_number.charAt(i));
            else sb.append("*");
        }
        
        return sb.toString();
    }
}