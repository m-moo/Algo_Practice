import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int cnt = 0;
        int s = 2;
        StringBuffer gems = new StringBuffer();
        while(s < (int)Math.sqrt(n)+1) {
            if(n % s == 0) {
                gems.append(s+" ");
                n /= s;
                s = 2;
                cnt++;
            }else s++;
        }
        gems.append(n);
        System.out.println(cnt+1);
        System.out.println(gems.toString());
    }
}
