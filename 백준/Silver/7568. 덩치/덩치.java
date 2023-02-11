
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        getNum(nums);
    }
    public static void getNum(int[][] nums){
        for(int i=0;i<nums.length;i++){
            int rs = 0;
            for(int j=0;j<nums.length;j++){
                if(j==i){
                    rs++;
                }else{
                    if(nums[i][0]<nums[j][0]&&nums[i][1]<nums[j][1]){
                        rs++;
                    }
                }
            }
            System.out.print(rs+" ");
        }
    }
}