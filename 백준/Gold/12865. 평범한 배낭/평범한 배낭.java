import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int wLimit;
    public static int[][] item;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        wLimit = Integer.parseInt(st.nextToken());

        item = new int[n][2];
        for(int i=0;i<n;i++){
            item[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        dp = new int[n+1][wLimit+1];
        System.out.println( recur(0,0));
    }

    static int recur(int idx, int weight){
        if(weight > wLimit) return Integer.MIN_VALUE;
        if(idx == n) return 0;
        if(dp[idx][weight] != 0) return dp[idx][weight];

        int w = item[idx][0];
        int v = item[idx][1];
        dp[idx][weight] = Math.max(recur(idx+1,weight+w)+v, recur(idx+1,weight));
        return dp[idx][weight];
    }
}
