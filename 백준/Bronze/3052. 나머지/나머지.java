import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int diff = 0;
		int nums[] = new int[10];
		for(int i=0;i<nums.length;i++) {
			nums[i]=sc.nextInt()%42;
			Boolean flag = true;
			for(int j=0;j<i;j++) {
				if(i!=0&&nums[i]==nums[j]) {
					flag=false;
				}
			}
			if(flag==true) {
				diff++;
			}
		}
		sc.close();
		System.out.print(diff);
	}
}