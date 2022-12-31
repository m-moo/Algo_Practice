import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String cal = (sc.nextInt()*sc.nextInt()*sc.nextInt())+"";
		sc.close();
		
		int[] nums = {0,0,0,0,0,0,0,0,0,0};
		
		for(int i=0;i<cal.length();i++) {
			nums[Integer.parseInt(cal.charAt(i)+"")]++;
		}
		for(int j=0;j<10;j++) {
			System.out.println(nums[j]);
		}
	}
}