import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();


        //list 초기화
        for(int i=0;i<=N;i++) {
            list.add(new ArrayList<>());
            dist[i] = 500001; // 무한대로 초기화(최대 마을개수 * 최대 시간)
        }

        //도로 정보 저장
        for(int i=0;i<road.length;i++) {
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }

        //다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int curr = node.val;

            if(visited[curr]) continue;
            visited[curr] = true;

            for(Node next:list.get(curr)) {
                if(dist[next.val] > dist[curr] + next.time) { // 최단 거리로 세팅
                   dist[next.val] = dist[curr] + next.time;
                   pq.add(new Node(next.val, dist[next.val]));
                }
            }
        }

        // K 시간 이하로 배달 가능한 마을의 개수 구하기
        for(int i=1;i<=N;i++) {
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
    
    class Node implements Comparable<Node> {
        int val;
        int time;

        Node(int val, int time) {
            this.val = val;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }
}