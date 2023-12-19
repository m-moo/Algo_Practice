import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static int R,C;
    public static Integer[][] dp;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        dp = new Integer[R][C];
        for(int i=0;i<R;i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(recur(0,0));
    }

    public static int recur(int r, int c) {
        if(r == R-1 && c == C-1) return 1;
        if(dp[r][c] != null) return dp[r][c];

        int route = 0;
        int curr = map[r][c];
        for(int i=0;i<4;i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];

            if(nr >= 0 && nc >= 0 && nr < R && nc < C) {
                if(curr > map[nr][nc]) route += recur(nr,nc);
            }
        }
        dp[r][c] = route;
        return dp[r][c];
    }
}
