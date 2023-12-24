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
        int goal = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int l = 0, r = n-1;
        int answer = 0;
        while(l < r) {
            int sum = nums[l]+nums[r];
            if(sum == goal) {
                answer++;
                r--;
                l++;
            }else if(sum < goal) l++;
            else if(sum > goal) r--;
        }
        System.out.println(answer);
    }
}
