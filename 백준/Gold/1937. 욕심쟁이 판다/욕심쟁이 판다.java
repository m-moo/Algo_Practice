import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static int n;
    public static int max;
    public static int[][] dp;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        max = Integer.MIN_VALUE;
        map = new int[n][n];
        dp = new int[n][n];
        for(int i=0;i<n;i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = recur(i,j);
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max+1);
    }

    public static int recur(int r, int c) {
        if(dp[r][c] == 0) {
            int curr = map[r][c];
            for(int i=0;i<4;i++) {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];

                if(nr < 0 || nc < 0 || nr == n || nc == n) continue;
                if(curr < map[nr][nc]) {
                    dp[r][c] = Math.max(dp[r][c],recur(nr,nc)+1);
                }
            }
        }
        return dp[r][c];
    }
}
