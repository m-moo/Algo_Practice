import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		double up = sc.nextInt(), dn = sc.nextInt(), top = sc.nextInt();
		int cnt = (int)((top-up)/(up-dn));
		System.out.println(top>(up*cnt)-(dn*cnt)+up?cnt+2:cnt+1);
	}
}