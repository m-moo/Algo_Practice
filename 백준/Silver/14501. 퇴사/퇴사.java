import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int maxP;
    public static int limit;
    public static int[][] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        limit = Integer.parseInt(br.readLine());

        schedule = new int[limit][2];
        for(int i=0;i<limit;i++){
            schedule[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        recur(0,0);
        System.out.println(maxP);
    }

    static void recur(int idx, int price){
        if(idx == limit) {
            maxP = Math.max(maxP, price);
            return;
        }

        int currT = schedule[idx][0];
        int currP = schedule[idx][1];
        //현재 스케쥴 진행
        if(idx+currT <= limit) {
            recur(idx+currT,price+currP);
        }
        //현재 스케쥴 진행X
        recur(idx+1,price);
    }
}
