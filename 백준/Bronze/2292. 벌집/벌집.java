import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), cnt=0, a=1;
		while(n>0) {
			a = a+(cnt*6);
			cnt++;
			if(n<=a) {
				break;
			}
		}
		System.out.println(cnt);
	}
}