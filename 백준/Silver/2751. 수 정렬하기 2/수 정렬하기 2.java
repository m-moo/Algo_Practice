import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[2000001];
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            arr[Integer.parseInt(bf.readLine())+1000000] = true;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]){
                sb.append((i-1000000)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
