import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt()-1;
		int a = 0, b = cnt<0?0:1, c;
		while(cnt>0) {
			c = a+b;
			a = b;
			b = c;
			cnt--;
		}
		System.out.println(b);
	}
}