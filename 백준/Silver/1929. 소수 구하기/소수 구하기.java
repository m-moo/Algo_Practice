import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt(), n2 = sc.nextInt();
		for(int i=n1;i<=n2;i++) {
			boolean flag = true;
			if(i!=1) {
				for(int j=2;j<=Math.sqrt(i);j++) {
					if(i%j==0) {
						flag = false;
						break;
					}
				}
			}else {
				flag = false;
			}
			if(flag==true) {
				System.out.println(i);
			}
		}
	}
}