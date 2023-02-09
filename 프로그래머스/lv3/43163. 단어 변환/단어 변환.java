class Solution {
    boolean[] visited;
    int answer = 51;
    String[] w;
    String t;
    public int solution(String begin, String target, String[] words) {
        t=target;
        w = words;
        visited = new boolean[words.length];

        backTrack(begin,0);
        if(answer == 51) answer = 0;
        return answer;
    }
    
    public void backTrack(String begin, int depth) {
        if(begin.equals(t)) {
            answer = Math.min(answer, depth);
            return;
        }

        for(int i=0;i<w.length;i++){
            if(!visited[i]){
                int diff = 0;
                for(int j=0;j<begin.length();j++){
                    if(begin.charAt(j) != w[i].charAt(j)) diff++;
                }
                if(diff == 1) {
                    visited[i] = true;
                    backTrack(w[i],depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}