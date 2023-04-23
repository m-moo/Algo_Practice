import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int num = sc.nextInt();
			int n1 = num/2, n2 = n1;
			while(true) {
				boolean flag = true;
				for(int j=2;j*j<=n1;j++) {
					if(n1%j==0) {
						flag = false;
						break;
					}
				}
				if(n1!=n2) {
					for(int j=2;j*j<=n2;j++) {
						if(n2%j==0) {
							flag = false;
							break;
						}
					}
				}
				if(flag==true) {
					System.out.println(n1+" "+n2);
					break;
				}else {
					n1--;
					n2++;
				}
				
			}
		}
	}
}