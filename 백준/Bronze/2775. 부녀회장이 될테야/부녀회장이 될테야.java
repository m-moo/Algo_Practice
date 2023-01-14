import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		for(int i=0;i<cnt;i++) {
			int k = sc.nextInt(), n = sc.nextInt();
			int[] room = new int[n];
			for(int j=0;j<=k;j++) {//층
				for(int m=0;m<n;m++) {//호
					if(j==0) {
						room[m] = m+1;
					}else {
						room[m] = m==0?1:room[m-1]+room[m];
					}
				}
			}
			System.out.println(room[n-1]);
		}
	}
}