class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        int cnt = 0;
        for(int i=0;i< cArr.length;i++) {
            char c = cArr[i];
            if(c!=' ') {
                cArr[i] = cnt++%2==0?Character.toUpperCase(c)
                    :Character.toLowerCase(c);
            }else cnt = 0;
        }
        
        return String.valueOf(cArr);
    }
}