import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n!=0) {
			int cnt=n*2-n;
			for(int i=n+1;i<=n*2;i++) {
				for(int j=2;j*j<=i;j++) {
					if(i%j==0) {
						cnt--;
						break;
					}
				}
			}
			System.out.println(cnt);
			n = sc.nextInt();
		}
	}
}