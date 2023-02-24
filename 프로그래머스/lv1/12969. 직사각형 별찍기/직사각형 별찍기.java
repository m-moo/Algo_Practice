import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<a;i++) {
            sb.append("*");
        }
        
        String star = sb.toString();
        for(int i=0;i<b;i++) {
            System.out.println(star);
        }
    }
}