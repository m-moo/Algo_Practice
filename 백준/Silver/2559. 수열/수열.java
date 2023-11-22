import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cons = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int tot = cons[0];
        int con = cons[1];
        int[] mem = new int[tot];
        mem[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            mem[i] = nums[i] + mem[i-1];
        }
        int max = mem[con-1];
        for(int i=con;i<mem.length;i++) {
            int sum = mem[i] - mem[i-con];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}