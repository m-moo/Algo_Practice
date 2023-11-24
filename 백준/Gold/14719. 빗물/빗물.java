import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conds = br.readLine().split(" ");

        int h = Integer.parseInt(conds[0]);
        int w = Integer.parseInt(conds[1]);
        int[] polls = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int maxIdx = 0;
        for(int i=0;i<w;i++) {
            maxIdx = polls[maxIdx]<polls[i]?i:maxIdx;
        }

        int tot = 0;
        int prev = polls[0];
        for(int i=1;i<=maxIdx;i++) {
            if(polls[i] >= prev) {
                prev = polls[i];
            }else {
                tot += prev - polls[i];
            }
        }
        prev = polls[w-1];
        for(int i=w-1;i>=maxIdx;i--) {
            if(polls[i] >= prev) {
                prev = polls[i];
            }else {
                tot += prev - polls[i];
            }
        }
        System.out.println(tot);
    }
}
