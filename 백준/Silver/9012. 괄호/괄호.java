import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {
            String q = sc.next();
            boolean flag = false;

            int end = 0;
            for (int j = 0; j < q.length(); j++) {
                if (q.charAt(j) == '(') {
                    end++;
                } else {
                    end--;
                }
                if(end<0){
                    break;
                }
            }
            if (end == 0) {
                flag = true;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}