import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		for(int i=0;i<cnt;i++) {
			int x = sc.nextInt(), y = sc.nextInt(); 
			int dif =(y-x)-2,
					top = (int)Math.round(Math.sqrt(dif));
			if(dif<3) {
				System.out.println(dif<=1?y-x:dif+1);
			}else {
				top = top<2?2:top;
				long n = 0, mid = 0;
				for(int j=2;j<=top;j++) {
					mid+=j;
					n++;
				}
				mid=mid*2;
				n = n*2;
				if(mid>dif) {
					mid = mid-top;
					n--;
				}
				if(mid<dif) {
					if(dif-mid<top) {
						n++;
					}else {
						if((dif-mid)%top==0) {
							n+=(dif-mid)/top;
						}else {
							n+=((dif-(mid+1))/top)+1;
						}
					}
				}
				System.out.println(n+2);
			}
			
		}
	}
}