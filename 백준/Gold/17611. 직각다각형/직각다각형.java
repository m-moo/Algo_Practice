import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int[][] map = new int[n][2];
        for(int i=0;i<n;i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
            minX = Math.min(minX,map[i][0]);
            maxX = Math.max(maxX,map[i][0]);
            minY = Math.min(minY,map[i][1]);
            maxY = Math.max(maxY,map[i][1]);
        }
        int[] h = new int[maxY-minY+1];
        int[] v = new int[maxX-minX+1];

        for(int i=0;i<n;i++) {
            int next = i+1==n?0:i+1;
            int x1 = map[i][0], y1 = map[i][1];
            int x2 = map[next][0], y2 = map[next][1];
            if(x1 == x2) {
                h[Math.min(y1,y2)-minY]++;
                h[Math.max(y1,y2)-minY]--;
            }else if(y1 == y2) {
                v[Math.min(x1,x2)-minX]++;
                v[Math.max(x1,x2)-minX]--;
            }
        }
        int max = Math.max(h[0],v[0]);
        for(int i=1;i<h.length;i++) {
            h[i] += h[i-1];
            max = Math.max(max,h[i]);
        }
        for(int i=1;i<v.length;i++) {
            v[i] += v[i-1];
            max = Math.max(max,v[i]);
        }
        System.out.println(max);
    }
}