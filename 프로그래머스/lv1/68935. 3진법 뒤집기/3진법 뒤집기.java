import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> lst = new ArrayList<>();
        while(true) {
            lst.add(n%3);
            if(n/3 < 3){
                int q = n/3;
                if(q != 0) lst.add(n/3);
                break;
            }
            n/=3;
        }

        for(int i=0;i<lst.size();i++) {
            answer += lst.get(i)*Math.pow(3,lst.size()-1-i);
        }
        
        return answer;
    }
}