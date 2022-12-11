import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer> lst = new ArrayList<>();

        while(n != 0){
            lst.add(n%10);
            n/=10;
        }
        Collections.sort(lst, Collections.reverseOrder());
        for(int num:lst){
            System.out.print(num);
        }
    }
}