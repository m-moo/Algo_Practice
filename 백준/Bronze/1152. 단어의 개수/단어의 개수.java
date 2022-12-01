import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int cnt=0,i=1;
		if(!n.equals(" ")) {
			while(true) {
				int b = n.indexOf(" ",i);
				if(b!=-1&&b!=n.length()-1) {
					cnt++;
					i=b+1;
				}else{
					break;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}