import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conditions = br.readLine().split(" ");

        int n = Integer.parseInt(conditions[0]);
        int caseCnt = Integer.parseInt(conditions[1]);

        int[][] map = new int[n][n];
        for(int i=0;i<n;i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        int[][] cases = new int[caseCnt][4];
        for(int i=0;i<caseCnt;i++) {
            cases[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        int[][] sum = new int[n+1][n+1];
        for(int i=1;i<sum.length;i++) {
            for(int j=1;j<sum.length;j++) {
                sum[i][j] = map[i-1][j-1] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }
        for(int i=0;i<caseCnt;i++) {
            int x1 = cases[i][0], y1 = cases[i][1];
            int x2 = cases[i][2], y2 = cases[i][3];
            System.out.println(sum[x2][y2] + sum[x1-1][y1-1] -
                sum[x2][y1-1] - sum[x1-1][y2]);
        }
    }
}
