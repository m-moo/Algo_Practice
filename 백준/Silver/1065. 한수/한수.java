import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), cnt=0, i=1;
		while(i<=num) {
			int loc=0,tot=0;
			if(i<100) {
				cnt++;
			}else {
				for(int j=0;j<Integer.toString(i).length();j++) {
					int n=(int)(i/Math.pow(10, j)%10);
					if(j==0) {
						loc=n;
					}else {
						int dif=loc-n;
						if(j!=1) {
							if(dif!=tot) {
								break;
							}else if(dif==tot&&j==Integer.toString(i).length()-1) {
								cnt++;
							}
						}else {
							tot=dif;
						}
						loc=n;
					}
				}
			}
			i++;
		}
		System.out.println(cnt);
	}
}