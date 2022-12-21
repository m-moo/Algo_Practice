import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), cnt = n;
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			if(a!=1) {
				for(int j=2;j<=a/2;j++) {
					if(a%j==0) {
						cnt--;
						break;
					}
				}
			}else {
				cnt--;
			}
		}
		System.out.println(cnt);
	}
}