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
        long x = Long.parseLong(st.nextToken());
        long[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToLong(Long::parseLong).toArray();
        Arrays.sort(nums);
        double min  = x/2.0;

        int l = 0, r = n-1;
        long answer = 0;
        int remain = 0;
        while(l <= r) {
            if(nums[r] == x) {
                answer++;
                r--;
                continue;
            }
            if(l == r) {
                remain++;
                break;
            }

            if(nums[l]+nums[r] >= min) {
                answer++;
                r--;
                l++;
            }else {
                l++;
                remain++;
            }
        }
        System.out.println(answer + remain/3);
    }
}
