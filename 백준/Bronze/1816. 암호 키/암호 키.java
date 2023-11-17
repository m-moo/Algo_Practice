import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        long[] arr = new long[cnt];
        for(int i=0;i<cnt;i++) {
            arr[i] = sc.nextLong();
        }

        for(int i=0;i<arr.length;i++) {
            long n = 2;
            long num = arr[i];
            while(n++ < 1_000_001) {
                if (num % n == 0) {
                    System.out.println("NO");
                    break;
                }
                if (n == 1_000_000) {
                    System.out.println("YES");
                }
            }
        }
    }
}