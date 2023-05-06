import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		for(int i=0;i<26;i++) {
			int num = n.indexOf(Character.toString((char)(97+i)));
			System.out.print(num+" ");
		}
	}
}