import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int cnt= sc.nextInt();
		for(int i=0;i<cnt;i++) {
			int scr=0,max=1;
			String xo=sc.next();
			for(int j=0;j<xo.length();j++) {
				if(xo.charAt(j)=='O') {
					scr+=max;
					max++;
				}else {
					max=1;
				}
			}
			System.out.println(scr);
		}
		sc.close();
	}
}