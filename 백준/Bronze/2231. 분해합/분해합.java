import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNum(n));
    }
    public static int getNum(int n){
        int length = (int)(Math.log10(n)+1);
        int min = n-(length*9);
        int rs = 0;
        while(min!=n){
            int sum=0;
            int num=min;
            while(num!=0){
                sum+=num%10;
                num/=10;
            }
            sum+=min;
            if(sum==n){
                return min;
            }
            min++;
        }

        return rs;
    }
}