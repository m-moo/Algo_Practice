import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] conditions = br.readLine().split(" ");

        int n = Integer.parseInt(conditions[0]);
        int h = Integer.parseInt(conditions[1]);

        int[] map = new int[n];
        for(int i=0;i<n;i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        int[] sum = new int[h];
        for(int i=0;i<n;i++) {
            if(i%2 == 0) {
                sum[0]++;
                sum[map[i]]--;
            }else{
                sum[h-map[i]]++;
            }
        }
        int min = sum[0];
        int cnt = 1;
        for(int i=1;i<h;i++) {
            sum[i] += sum[i-1];
            if(min > sum[i]) {
                min = sum[i];
                cnt = 1;
            }else if(min == sum[i]) {
                cnt++;
            }
        }
        System.out.printf("%d %d",min,cnt);
    }
}
