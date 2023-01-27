import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int cnt= sc.nextInt();
		for(int i=0;i<cnt;i++) {
			double avg=0,hscr=0;
			int num = sc.nextInt();
			int[] scr = new int[num];
			for(int j=0;j<scr.length;j++) {
				scr[j] = sc.nextInt();
				avg+=scr[j]; 
			}
			avg=(avg/num);
			for(int j=0;j<scr.length;j++) {
				if(avg<scr[j]) {
					hscr++;
				}
			}
			System.out.println(String.format("%.3f", hscr/num*100)+"%");
		}
		sc.close();
	}
}