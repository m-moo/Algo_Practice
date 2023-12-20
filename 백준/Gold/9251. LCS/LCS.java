import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String m,n;
    public static int[][] dp;
    public static int[][] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = br.readLine();
        n = br.readLine();
        dp = new int[m.length()+1][n.length()+1];

        char[] arrM = m.toCharArray();
        char[] arrN = n.toCharArray();
        for(int i=1;i<=arrM.length;i++) {
            for(int j=1;j<=arrN.length;j++) {
                if(arrM[i-1] == arrN[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[m.length()][n.length()]);
    }
}
