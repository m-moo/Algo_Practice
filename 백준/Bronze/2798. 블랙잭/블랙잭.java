import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(bj(n,m,nums));
    }
    public static int bj(int n, int m, int[] nums){
        int rs = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum == m){
                        return sum;
                    }else if(sum>rs && sum<m) {
                        rs = sum;
                    }
                }
            }
        }
        return rs;
    }
}