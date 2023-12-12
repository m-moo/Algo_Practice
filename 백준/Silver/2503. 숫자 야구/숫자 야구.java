import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int limit;
    public static int answer;
    public static String[][] hints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] hint = new String[n][3];

        for(int i=0;i<n;i++) {
            hint[i] = br.readLine().split(" ");
        }

        hints = hint;
        answer = 0;
        limit = n;
        recur(0, 100);
        System.out.print(answer);
    }

    public static void recur(int hintIdx, int num) {
        if(hintIdx == limit) {
            answer++;
            recur(0, num+1);
            return;
        }
        if(num == 1000) return;

        if(check(hintIdx, num)){
            recur(hintIdx+1, num);
        }else {
            recur(0, num+1);
        }
    }

    public static boolean check(int idx, int num) {
        String[] hint = hints[idx];
        char[] target = hint[0].toCharArray();
        int strike = Integer.parseInt(hint[1]), ball = Integer.parseInt(hint[2]);

        int a = num/100;
        int b = num/10 - a*10;
        int c = num - a*100 - b*10;
        if(a == 0 || b == 0 || c == 0 || 
            a == b || b == c || a == c) return false;

        int ta = target[0]-'0';
        int tb = target[1]-'0';
        int tc = target[2]-'0';

        int stCnt = 0, bCnt = 0;
        if(a == ta) stCnt++;
        else if(a == tb) bCnt++;
        else if(a == tc) bCnt++;

        if(b == tb) stCnt++;
        else if(b == ta) bCnt++;
        else if(b == tc) bCnt++;

        if(c == tc) stCnt++;
        else if(c == tb) bCnt++;
        else if(c == ta) bCnt++;

        if(strike == stCnt && ball == bCnt) return true;
        return false;
    }
}
