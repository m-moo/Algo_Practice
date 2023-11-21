import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int s = 2;
        while(n != 1) {
            if(n % s == 0) {
                System.out.println(s);
                n /= s;
                s = 2;
            }else s++;
        }
    }
}