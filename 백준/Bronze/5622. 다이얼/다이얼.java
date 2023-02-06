import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int time = 0;
		String[] dial = {"ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		for(int i=0;i<word.length();i++) {
			for(int j=0;j<dial.length;j++) {
				if(dial[j].contains(Character.toString(word.charAt(i)))){
					time+=j+3;
				}
			}
		}
		System.out.println(time);
	}
}