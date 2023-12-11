import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] log;
    public static int cntLimit, depthLimit;
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

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
        for(int i=1;i<=cntLimit;i++) {
            log[depth] = i;
            recur(depth+1);
        }
    }
}
