import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();

        // create graph
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] e:edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // init distance
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // start node
        int max = 0;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int neighbor:graph.get(curr)) {
                if(distances[neighbor] == -1) {
                    distances[neighbor] = distances[curr]+1;
                    q.offer(neighbor);
                    max = distances[neighbor];
                }
            }
        }
        int cnt = 0;
        for (int d:distances) {
            if (d == max) cnt++;
        }
        return cnt;
    }
}