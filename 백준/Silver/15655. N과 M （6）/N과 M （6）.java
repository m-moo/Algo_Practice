import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums;
    public static int[] log;
    public static boolean[] visited;
    public static int[] history;
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
        visited = new boolean[cntLimit];
        history = new int[(int)Math.pow(2,cntLimit)];

        recur(0, 0);
        System.out.print(output);
    }

    public static void recur(int depth, int c) {
        if(depth == depthLimit) {
            if(history[c] == 0) {
                for(int i=0;i<depthLimit;i++) {
                    output.append(log[i]).append(" ");
                }
                output.append('\n');
                history[c]++;
            }
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(visited[i]) continue;
            log[depth] = nums[i];
            visited[i] = true;
            recur(depth+1, c+(int)Math.pow(2,i));
            visited[i] = false;
        }
    }
}
