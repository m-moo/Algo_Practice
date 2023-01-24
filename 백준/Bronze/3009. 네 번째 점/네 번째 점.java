import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3],y = new int [3];
		for(int i=0;i<3;i++) {
			x[i]= sc.nextInt();
			y[i] = sc.nextInt();
		}
		int a,b;
		if(x[0]==x[1]) {
			a = x[2];
		}else {
			if(x[1]==x[2]) {
				a = x[0];
			}else {
				a = x[1];
			}
		}
		if(y[0]==y[1]) {
			b = y[2];
		}else {
			if(y[1]==y[2]) {
				b = y[0];
			}else {
				b = y[1];
			}
		}
		System.out.println(a+" "+b);
	}
}