import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int idx = col-1;
                return o1[idx]==o2[idx]?o2[0]-o1[0]:o1[idx]-o2[idx];
            }
        });

        for(int i=row_begin-1;i<=row_end-1;i++) {
            int sum = 0;
            for(int j=0;j<data[i].length;j++) {
                sum += data[i][j] % (i+1);
            }
            answer ^= sum;
        }
        return answer;
    }
}