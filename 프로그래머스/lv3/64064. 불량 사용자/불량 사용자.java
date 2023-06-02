import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        backTrack(user_id,banned_id,0,0);

        return set.size();
    }
    
    // bit : 방문 순서 기록
    public void backTrack(String[] user_id, String[] banned_id, int bit, int idx) {
        if(idx == banned_id.length) {
            set.add(bit);
            return;
        }
        String reg = banned_id[idx].replace("*", "[\\w\\d]");
        for(int i=0; i<user_id.length; ++i) {
            if((((bit>>i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            backTrack(user_id, banned_id, (bit | 1<<i), idx+1);
        }
    }
}