import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a = 0;
		for(int i=0;i<=n/5;i++) {
			int rs = n-(i*5);
			if(rs==0) {
				a = i;
			}else if(rs%3==0) {
				a = i+(rs/3);
			}else {
				a = a>0?a:-1;
			}
		}
		System.out.println(a);
	}
}