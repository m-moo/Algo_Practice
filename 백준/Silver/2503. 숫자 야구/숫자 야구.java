import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][3];
        for(int i=0;i<n;i++) {
            int[] m = new int[3];
            m[0] = sc.nextInt();
            m[1] = sc.nextInt();
            m[2] = sc.nextInt();
            map[i] = m;
        }
        int answer = 0;
        for(int a=1;a<10;a++) {
            for(int b=1;b<10;b++) {
                for(int c=1;c<10;c++) {
                    if(a == b || a == c || b == c) continue;

                    int cnt = 0;
                    for(int[] m:map) {
                        int num = m[0], strike = m[1], ball = m[2];

                        int aH = num/100;
                        int bH = num/10 - aH*10;
                        int cH = num - aH*100 - bH*10;

                        int ballCnt = 0, strikeCnt = 0;
                        if(a == aH) strikeCnt++;
                        else if(a == bH) ballCnt++;
                        else if(a == cH) ballCnt++;

                        if(b == bH) strikeCnt++;
                        else if(b == aH) ballCnt++;
                        else if(b == cH) ballCnt++;

                        if(c == cH) strikeCnt++;
                        else if(c == bH) ballCnt++;
                        else if(c == aH) ballCnt++;

                        if(ball == ballCnt && strike == strikeCnt) cnt++;
                    }
                    if(cnt == n) answer++;
                }
            }
        }
        System.out.println(answer);
    }

}