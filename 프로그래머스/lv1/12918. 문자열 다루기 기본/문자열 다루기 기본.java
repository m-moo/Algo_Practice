class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if(len == 4 || len == 6) {
          try{
              int x = Integer.parseInt(s);
              return true;
          } catch(NumberFormatException e){
              return false;
          }
        }
        else return false;
    }
}