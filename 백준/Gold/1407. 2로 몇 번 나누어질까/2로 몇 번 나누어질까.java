import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToLong(Long::parseLong).toArray();

        long a = nums[0]-1;
        long b = nums[1];
        System.out.println(getCount(b)-getCount(a));
    }
    public static long getCount(long n) {
        long sum = 0;
        long i = 1;
        long tmp;
        while(n > 0) {
            if(n % 2 == 0) tmp = n/2;
            else tmp = n/2+1;

            sum += tmp*i;
            n -= tmp;
            i*=2;
        }
        return sum;
    }
}
