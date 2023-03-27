import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++) {
            int len = phone_book[i].length();
            if(len < phone_book[i+1].length()) {
                if(phone_book[i+1].substring(0,len).equals(phone_book[i])) return false;
            }
        }
        return true;
    }
}