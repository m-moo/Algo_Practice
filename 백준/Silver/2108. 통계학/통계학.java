import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] chk = new int[8001];
        ArrayList<Integer> lst = new ArrayList<>();
        int max=0,sum=0,maxN=0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
            sum+=arr[i];
            chk[arr[i]+4000]++;
        }
        Arrays.sort(arr);
        System.out.println((int)Math.round((double)sum/n));
        System.out.println(arr[n/2]);
        for(int i=0;i<8001;i++){
            if(chk[i]==max&&flag==false){
                max=chk[i];
                maxN=i-4000;
                flag = true;
            }
            if(chk[i]>max){
                max=chk[i];
                maxN=i-4000;
                flag = false;
            }
        }
        System.out.println(maxN);
        System.out.println(arr[n-1]-arr[0]);

    }
}