import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] dp;
    public static int[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lines = new int[n][2];
        for(int i=0;i<n;i++) {
            lines[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(lines, Comparator.comparingInt(l -> l[0]));
        dp = new int[lines[n-1][0]];

        int max = 0;
        for(int i=0;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(n-max);
    }
}
