import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        visit = new boolean[n];
        getNums(n,m,0,0);
    }

    public static void getNums(int n,int m,int depth,int start){
        if(m==depth){
            for(int val:arr){
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                getNums(n,m,depth+1,i+1);
                visit[i]=false;
            }
        }
    }
}