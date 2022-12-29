import java.util.Scanner;

public class Main {
	
	public static StringBuffer prt = new StringBuffer();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		star(n,0,1);
		System.out.println(prt);
	}
	static void star(int n, int l, int r) {
		int cnt = n;
		while(cnt!=0) {
			for(int i=1;i<4;i++) {
				if(i==2&&(n/3<r%n&&r%n<=n-(n/3))){
					for(int j=0;j<n/3;j++) {
						prt.append(" ");
					}
				}else if(n/3!=1) {
					star(n/3,l+1,r);
				}else {
					prt.append("*");
				}
			}
			if(l!=0) {
				break;
			}else {
				prt.append("\n");
			}
			cnt--;
			r++;
		}
	}
}