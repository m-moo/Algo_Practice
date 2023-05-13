import java.util.Arrays;

class Solution {
    public int solution(String[] babbling) {
        String[] canDo = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(int i=0;i<babbling.length;i++) {
            boolean[] visited = new boolean[canDo.length];
            StringBuilder sb = new StringBuilder();
            int curr = 0;
            while(curr < babbling[i].length()) {
                sb.append(babbling[i].charAt(curr));
                int idx = Arrays.asList(canDo).indexOf(sb.toString());
                if(idx >= 0){
                    if(!visited[idx]) {
                        visited[idx] = true;
                        sb.delete(0,sb.length());
                    }
                    else break;
                }
                curr++;
            }
            if(sb.length() == 0) answer++;
        }
        
        return answer;
    }
}