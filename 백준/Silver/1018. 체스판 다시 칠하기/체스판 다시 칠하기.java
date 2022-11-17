import java.util.Scanner;

public class Main {
    public static Boolean[][] arr;
    public static int min=64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new Boolean[n][m];

        for(int i=0;i<n;i++){
            String[] str = sc.next().split("");
            for(int j=0;j<m;j++){
                if(str[j].equals("W")){
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }

            }
        }
        int x=n-7;
        int y=m-7;
        
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                getNum(i,j);
            }
        }
        System.out.println(min);
    }
    public static void getNum(int n, int m){
        int x=n+8;
        int y=m+8;
        int rs = 0;
        boolean tf = arr[n][m];
        for(int i=n;i<x;i++){
            for(int j=m;j<y;j++){
                if(arr[i][j]!=tf){
                    rs++;
                }
                tf = !tf;
            }
            tf = !tf;
        }

        rs = Math.min(rs,64-rs);
        min = Math.min(min, rs);
    }
}