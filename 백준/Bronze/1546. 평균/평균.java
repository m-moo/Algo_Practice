import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		double max = 0;
		double avg = 0;
		int[] nums = new int[cnt];
		for(int i=0;i<cnt;i++) {
			nums[i]=sc.nextInt();
			max = nums[i]>max?nums[i]:max;
		}
		sc.close();
		for(int i=0;i<cnt;i++) {
			avg =(nums[i]/max*100)+avg;
		}
		System.out.println(avg/cnt);
	}
}