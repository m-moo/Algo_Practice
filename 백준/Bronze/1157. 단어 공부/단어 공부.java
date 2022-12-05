import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		sc.close();
		n=n.toUpperCase();
		int max=0, num=0;
		int[] cnt = new int[26];
		for(int i=0;i<n.length();i++) {
			cnt[(int)n.charAt(i)-65]++;
		}
		for(int j=0;j<cnt.length;j++) {
			if(max<cnt[j]) {
				max=cnt[j];
				num = j+65;
			}else if(max==cnt[j]) {
				num=63;
			}
		}
		System.out.println((char)num);
	}
}