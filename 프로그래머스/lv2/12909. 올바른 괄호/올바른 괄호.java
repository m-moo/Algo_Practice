class Solution {
    boolean solution(String s) {
        int total = 0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                total++;
            }else{
                total--;
            }
            if(total<0){
                return false;
            }
        }
        return total==0;
    }
}