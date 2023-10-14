import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int cnt = sc.nextInt();
        int limit = sc.nextInt();

        int[] weight = new int[cnt+1];
        int[] value = new int[cnt+1];
        int[][] dp = new int[cnt+1][limit+1];

        for(int i=1;i<=cnt;i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for(int i=1;i<=cnt;i++) {
            int currW = weight[i];
            int currV = value[i];
            for(int j=1;j<=limit;j++) {
                if(currW <= j) { // 넣을 수 있는 경우
                    // 이전의 무게에서 가능했던 최대 value와 현재 아이템을 넣었을 때
                    // value를 비교하여 큰 쪽을 넣는다.
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-currW] + currV);
                }else { // 넣을 수 없는 경우
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[cnt][limit]);
    }
}