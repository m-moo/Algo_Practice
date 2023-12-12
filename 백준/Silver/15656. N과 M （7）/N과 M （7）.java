import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums;
    public static int[] log;
    public static int cntLimit, depthLimit;
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).sorted().toArray();

        nums = arr;
        cntLimit = Integer.parseInt(st.nextToken());
        depthLimit = Integer.parseInt(st.nextToken());
        log = new int[depthLimit];

        recur(0);
        System.out.print(output);
    }

    public static void recur(int depth) {
        if(depth == depthLimit) {
            for(int i=0;i<depthLimit;i++) {
                output.append(log[i]).append(" ");
            }
            output.append('\n');
            return;
        }
        for(int i=0;i<nums.length;i++) {
            log[depth] = nums[i];
            recur(depth+1);
        }
    }
}
