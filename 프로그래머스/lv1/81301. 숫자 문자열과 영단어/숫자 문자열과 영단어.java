import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String s) {
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int answer = 0;
        
        StringBuffer num = new StringBuffer();
        List<Integer> numList = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c < 'A') numList.add(c-'0');
            else{
                num.append(c);
                int idx = Arrays.asList(nums).indexOf(num.toString());
                if(idx > -1) {
                    numList.add(idx);
                    num.delete(0,num.length());
                }
            }
        }

        int len = numList.size();
        for(int i=0;i<len;i++) {
            answer += numList.get(i) * (Math.pow(10,len-1-i));
        }
        
        return answer;
    }
}