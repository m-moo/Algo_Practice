import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int nums[] = new int[9];
		int max=0;
		int num=0;
		
		for(int i=0;i<9;i++) {
			nums[i] = sc.nextInt();
		}
		for(int j=0;j<9;j++) {
			if(nums[j]>max) {
				max = nums[j];
				num=j+1;
			}
		}
		
		System.out.print(max+"\n"+num);
	}
}