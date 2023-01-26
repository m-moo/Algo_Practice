import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true) {
			Integer[] nums = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
			if(nums[0]==0&&nums[1]==0&&nums[2]==0) {
				break;
			}
			Arrays.sort(nums,Collections.reverseOrder());
			double a = nums[0], b = nums[1], c = nums[2];
			if(Math.pow(a, 2)==Math.pow(b, 2)+Math.pow(c, 2)) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
	}
}