import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        /* picks : [dia,iron,stone] */
        int[][] stress = {{1,1,1},{5,1,1},{25,5,1}};
        
        int answer = 0;
        List<int[]> score = new ArrayList<>();

        /* init mineral Kind per pick */
        int pickCount = picks[0]+picks[1]+picks[2];

        int dia = 0, iron = 0, stone = 0, mineralCnt = 0;
        for(int i=0; i < minerals.length
                && score.size() < pickCount ;i++){
            int mineral = minerals[i].length()-3;
            mineral = mineral > 2 ? 0 : mineral;

            dia += stress[0][mineral];
            iron += stress[1][mineral];
            stone += stress[2][mineral];

            if(mineralCnt++ == 4 || i == minerals.length-1) {
                score.add(new int[]{dia,iron,stone});
                dia = iron = stone = mineralCnt = 0;
            }
        }

        Collections.sort(score,((o1,o2)-> o2[2] - o1[2]));
        int idx = 0;
        /* calculate total stress */
        for(int[] s:score) {
            while(idx < 3) {
                if(picks[idx] != 0) break;
                idx++;
            }

            if(idx > 2) break;
            picks[idx]--;
            answer+=s[idx];
        }
        return answer;
    }
}