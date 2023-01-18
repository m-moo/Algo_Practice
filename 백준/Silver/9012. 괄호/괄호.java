import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            char arr[] = br.readLine().toCharArray();
            boolean flag = false;

            int end = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') end++;
                else end--;
                
                if(end<0) break;
            }
            if (end == 0) {
                flag = true;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}