import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] polls = new int[n][2];

        for(int i=0;i<n;i++) {
            polls[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(polls, ((o1, o2) -> o1[0] - o2[0]));

        int maxIdx = 0;
        for(int i=0;i<n;i++) {
            maxIdx = polls[maxIdx][1]<polls[i][1]?i:maxIdx;
        }

        int tot = polls[maxIdx][1];
        int[] prev = polls[0];
        for(int i=1;i<=maxIdx;i++) {
            if(polls[i][1] >= prev[1]) {
                tot += (polls[i][0]-prev[0]) * prev[1];
                prev = polls[i];
            }
        }

        prev = polls[n-1];
        for(int i=n-2;i>=maxIdx;i--) {
            if(polls[i][1] >= prev[1]) {
                tot += (prev[0] - polls[i][0]) * prev[1];
                prev = polls[i];
            }
        }
        System.out.println(tot);
    }
}
