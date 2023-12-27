import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int s = 1, e = 0;
        st = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        for(int i=0;i<n;i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e,trees[i]);
        }

        while(s <= e) {
            int mid = (s+e)/2;
            long gain = 0;
            for(int tree:trees) {
                if(tree >= mid) gain += tree-mid;
            }

            if(gain >= m) s = mid+1;
            else e = mid-1;
        }
        System.out.println(e);
    }
}
