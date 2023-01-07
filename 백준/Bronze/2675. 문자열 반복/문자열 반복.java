import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			int cnt = sc.nextInt();
			String n = sc.next(), word="";
			for(int j=0;j<n.length();j++) {
				for(int k=0;k<cnt;k++) {
					word+=n.substring(j,j+1);
				}
			}
			System.out.println(word);
		}
	}
}