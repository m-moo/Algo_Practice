import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];
        int[][] dp = new int[n+1][3];
        for(int i=0;i<n;i++) {
            cost[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        for(int i=1;i<=n;i++) {
            for(int rgb=0;rgb<3;rgb++) {
                if (rgb == 0) {
                    dp[i][rgb] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i - 1][rgb];
                } else if (rgb == 1) {
                    dp[i][rgb] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i - 1][rgb];
                } else {
                    dp[i][rgb] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i - 1][rgb];
                }
            }
        }
        System.out.println(Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2])));
    }
}
