import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int[] mem = new int[n];
        mem[0] = nums[0];
        int max = mem[0];
        for(int i=1;i<nums.length;i++) {
            mem[i] = Math.max(nums[i] + mem[i-1], nums[i]);
            max = Math.max(max,mem[i]);
        }
        System.out.println(max);
    }
}