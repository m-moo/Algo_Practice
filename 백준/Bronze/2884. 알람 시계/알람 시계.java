import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		if(b-45<0) {
			b = 60+(b-45);
			a = a-1<0?23:a-1;
		}else {
			b =  b-45;
		}
		System.out.print(a+" "+b);
	}
}
