import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for(int i=0;i<6;i++) {
            arr[i] = sc.nextInt();
        }
        int a = arr[0], b = arr[1], c = arr[2],
            d = arr[3], e = arr[4], f = arr[5];
        boolean flag = false;
        for(int x=-999;x<=999;x++) {
            for(int y=-999;y<=999;y++){
                if(a*x + b*y == c && d*x + e*y == f) {
                    System.out.println(x);
                    System.out.println(y);
                    flag = true;
                }
                if(flag) break;
            }
            if(flag) break;
        }
    }

}