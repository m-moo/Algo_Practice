import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0];
            }
        });
        ArrayList<Integer> cams = new ArrayList<>();
        cams.add(routes[0][0]);
        for(int i=1;i<routes.length;i++) {
            boolean flag = false;
            for(Integer c:cams) {
                if(routes[i][0] <= c && routes[i][1] >= c) {
                    flag = true;
                    break;
                }
            }
            if(!flag) cams.add(routes[i][0]);
        }
        return cams.size();
    }
}