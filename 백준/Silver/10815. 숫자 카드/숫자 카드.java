import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrN = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        int[] arrM = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arrN);

        int[] answer = new int[m];
        for(int i=0;i<arrM.length;i++) {
            int s = 0, e = n-1, mid = (s+e)/2;
            while(s <= e) {
                if(arrM[i] == arrN[mid]) {
                    answer[i] = 1;
                    break;
                }else if(arrM[i] < arrN[mid]) e = mid-1;
                else if(arrN[mid] < arrM[i]) s = mid+1;
                mid = (s+e)/2;
            }
        }
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
