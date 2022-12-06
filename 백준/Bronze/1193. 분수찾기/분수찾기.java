import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), a=1, b=1,cnt=1;
		while(cnt!=n) {
			if(a==1&&b%2!=0) {
				b++;cnt++;
				int num = b;
				while(a!=num) {
					if(cnt==n) {
						break;
					}
					b--;a++;cnt++;
				}
			}else if(b==1&&a%2==0) {
				a++;cnt++;
				int num = a;
				while(b!=num) {
					if(cnt==n) {
						break;
					}
					a--;b++;cnt++;
				}
			}
		}
		System.out.println(a+"/"+b);
	}
}