import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		String[] alph = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0;i<alph.length;i++) {
			if(word.contains(alph[i])) {
				word = word.replaceAll(alph[i], "1");
			}
		}
		System.out.println(word.length());
	}
}