import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] dp;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        dp = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int answer = 0;
        for(int i=0;i<n;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
