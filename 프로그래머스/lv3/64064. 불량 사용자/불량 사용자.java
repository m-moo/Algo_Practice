import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    Set<List<String>> rs = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];

        backTrack(user_id,banned_id,visited,0);

        return rs.size();
    }
    
    public boolean isMatch(String userId, String bannedId) {
        String regex = "^" + bannedId.replace("*",".") + "$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(userId);
        return matcher.find();
    }

    public void backTrack(String[] user_id, String[] banned_id, boolean[] visited, int idx) {
        if(idx == banned_id.length) {
            List<String> list = new ArrayList<>();
            for(int i=0;i<visited.length;i++) {
                if(visited[i]) list.add(user_id[i]);
            }
            rs.add(list);
            return;
        }

        for(int i=0;i<user_id.length;i++){
            if(visited[i]) continue;

            if(isMatch(user_id[i], banned_id[idx])) {
                visited[i] = true;
                backTrack(user_id,banned_id,visited,idx+1);
                visited[i] = false;
            }
        }
    }
}