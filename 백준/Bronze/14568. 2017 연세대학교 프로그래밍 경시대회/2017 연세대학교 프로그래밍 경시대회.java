import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int candy = sc.nextInt();
        int answer = 0;
        for(int a=1;a<candy;a++)
            for(int b=1;b<candy;b++)
                for(int c=1;c<=candy;c++) {
                    if(a+b+c == candy &&
                        a >= b+2 && c%2 == 0) {
                        answer++;
                    }
                }
        System.out.println(answer);
    }
}