import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    class Pair {
        int x, count;

        Pair(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
    
    public int solution(int x, int y, int n) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Pair(x, 0));
        visited.add(x);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int curX = current.x;
            int curCount = current.count;

            if (curX == y) {
                return curCount;
            }

            int[] nextXs = {curX + n, curX * 2, curX * 3};

            for (int nextX : nextXs) {
                if (nextX > 0 && nextX <= y && !visited.contains(nextX)) {
                    queue.add(new Pair(nextX, curCount + 1));
                    visited.add(nextX);
                }
            }
        }

        return -1;
    }
}