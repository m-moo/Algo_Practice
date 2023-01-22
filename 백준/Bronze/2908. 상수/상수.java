import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(new StringBuffer(sc.next()).reverse().toString());
		int b = Integer.parseInt(new StringBuffer(sc.next()).reverse().toString());
		System.out.println(a>b?a:b);
	}

}