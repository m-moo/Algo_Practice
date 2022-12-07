import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = num;
		for(int j=0;j<num;j++) {
			String word = sc.next();
			for(int i=0;i<word.length();i++) {
				int rs = word.indexOf(word.charAt(i), i+1);
				if(rs!=-1&&rs!=i+1){
					cnt-=1;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}