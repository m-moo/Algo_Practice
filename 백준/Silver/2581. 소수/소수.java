import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt(), n2 = sc.nextInt(), tot = 0, min = n2;
		for(int i=n1;i<=n2;i++) {
			boolean flag = true;
			if(i!=1) {
				for(int j=2;j<=i/2;j++) {
					if(i%j==0) {
						flag = false;
						break;
					}
				}
			}else {
				flag = false;
			}
			if(flag==true) {
				tot+=i;
				min = min>i?i:min;
			}
		}
		System.out.println(tot==0?-1:tot+"\n"+min);
	}
}