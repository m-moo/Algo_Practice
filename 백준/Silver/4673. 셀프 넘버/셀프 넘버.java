import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		int i = 0;
		int[] arr = new int[10036];
		while(true) {
			int n = 0;
			String num = Integer.toString(i);
			for(int j=0;j<num.length();j++) {
				n+=Integer.parseInt(Character.toString(num.charAt(j)));
			}
			if(i>10000) {
				break;
			}else {
				arr[n+i]++; 
				i++;
			}
		}
		for(int j=0;j<arr.length;j++) {
			if(arr[j]==0&&j<10000) {
				System.out.println(j);
			}
		}
	}
}