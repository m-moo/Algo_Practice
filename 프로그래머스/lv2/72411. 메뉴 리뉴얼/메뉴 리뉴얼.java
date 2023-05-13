import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    HashMap<String,Integer> map;
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=0;i<course.length;i++) {
            map = new HashMap<>();
            max = 0;
            for(int j=0;j< orders.length;j++) {
                if(orders[j].length() >= course[i]) dfs(orders[j],"",0,0,course[i]);
            }
            for(String m:map.keySet()) {
                if(map.get(m) == max && max > 1) pq.offer(m);
            }
        }

        answer = new String[pq.size()];
        for(int i=0;i<answer.length;i++) answer[i] = pq.poll();

        return answer;
    }
    
    public void dfs(String course, String w, int idx, int depth, int target) {
        if(depth == target) {
            char[] arr = w.toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for(char c:arr) sb.append(c);
            w = sb.toString();
            
            map.put(w, map.getOrDefault(w,0)+1);
            max = Math.max(max,map.get(w));
            return;
        }
        for(int i=idx;i<course.length();++i) {
            char now = course.charAt(i);
            dfs(course,w+now,i+1,depth+1,target);
        }
    }
}