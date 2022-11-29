import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt(), h = sc.nextInt();
		x = w-x>x?x:w-x;
		y = h-y>y?y:h-y;
		System.out.println(x>y?y:x);
	}
}