import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] mt = new int[n][2];
        for(int i=0;i<mt.length;i++) {
            st = new StringTokenizer(br.readLine()," ");
            mt[i][0] = Integer.parseInt(st.nextToken());
            mt[i][1] = Integer.parseInt(st.nextToken());
        }

        /* 끝나는 시간을 기준으로 정렬 */
        Arrays.sort(mt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /* 종료 시간이 같을 경우 시작시간이 빠른 순으로 정렬 */
                if(o1[1] == o2[1]) return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int answer = 1;
        int curr = mt[0][1];
        for(int i=1;i< mt.length;i++) {
            /* 현재 시간이 시작 시간보다 작거나 같을 경우 */
            if(curr <= mt[i][0]) {
                curr = mt[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}