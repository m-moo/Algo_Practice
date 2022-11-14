import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x1 = sc.nextInt(), y1 = sc.nextInt(),r1 = sc.nextInt(),
					x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();
			System.out.println(cal(x1, y1, r1, x2, y2, r2));
		}
	}
	public static int cal(int x1, int y1, int r1, int x2, int y2, int r2) {
		double cal = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
		int rs;
		if(cal==0) {//동심원의 경우
			rs = r1==r2?-1:0;
		}else {
			int bt = r1>r2?r1-r2:r2-r1;
			if(r1+r2<cal || bt>cal) {//만나지 않음
				rs = 0;
			}else {
				if(cal==r1+r2||bt==cal) {//한점에서 만남
					rs = 1;
				}else {
					rs = 2;
				}
			}
		}
		return rs;
	}
}