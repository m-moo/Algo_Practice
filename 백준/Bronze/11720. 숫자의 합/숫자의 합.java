import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt(), tot=0;
		String num = sc.next();
		for(int i=0;i<cnt;i++) {
			tot+=Integer.parseInt(num.substring(i,i+1));
		}
		System.out.println(tot);
	}
}