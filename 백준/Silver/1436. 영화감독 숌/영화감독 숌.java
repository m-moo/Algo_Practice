import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt=0, m = 665;
        while(cnt!=n){
            m++;
            String str = Integer.toString(m);
            if(str.indexOf("666")>-1){
                cnt++;
            }
        }
        System.out.println(m);
    }
}