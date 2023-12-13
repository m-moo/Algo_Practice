import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int limit;
    public static int answer;
    public static int[][] ing;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        ing = arr;
        answer = Integer.MAX_VALUE;
        limit = n;
        recur(0,1,0);
        System.out.println(answer);
    }

    public static void recur(int idx, int sour, int bitter) {
        if(idx == limit) {
            if(sour != 0 && bitter != 0) {
                int rs = Math.abs(sour-bitter);
                answer = Math.min(answer,rs);
            }
            return;
        }
        recur(idx+1,sour * ing[idx][0],bitter + ing[idx][1]);
        recur(idx+1,sour,bitter);
    }
}
