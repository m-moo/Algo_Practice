import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] line = new int[n];
        int answer = 0;

        for(int i=0;i<line.length;i++) {
            line[i] = sc.nextInt();
        }

        Arrays.sort(line); // 정렬

        int waited = 0; // 대기시간
        for(int i=0;i<line.length;i++) {
            answer += waited+line[i]; // 대기시간 + 실행시간 
            waited += line[i]; // 다음 사람의 대기 시간 계산
        }
        
        System.out.println(answer);
    }
}