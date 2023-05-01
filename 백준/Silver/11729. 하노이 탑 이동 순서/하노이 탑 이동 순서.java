
import java.util.Scanner;

public class Main {
    public static int cnt = 0;
    public static StringBuilder rs = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        move(n,1,2,3);
        System.out.println(cnt);
        System.out.println(rs);
    }
    public static void move(int num, int from , int mid, int to) {
        cnt ++;
        if(num==1) {
            rs.append(from + " " + to+"\n");
            return;
        }
        move(num-1,from,to,mid); // n-1개를 1에서 2로 이동
        rs.append(from+" "+to+"\n"); // 1개를 1에서 3로 이동
        move(num-1,mid,from,to); //n-1개를 2에서 3로 이동

    }
}
