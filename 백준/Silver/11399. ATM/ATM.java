import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<line.length;i++) {
            line[i] = Integer.parseInt(st.nextToken());
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