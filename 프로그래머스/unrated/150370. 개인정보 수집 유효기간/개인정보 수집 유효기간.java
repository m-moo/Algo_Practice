import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] todayArr = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        HashMap<String,Integer> termMap = new HashMap<>();
        for(int i=0;i<terms.length;i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        for(int i=0;i<privacies.length;i++) {
            String[] prv = privacies[i].split(" ");
            int[] end = Arrays.stream(prv[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            int term = termMap.get(prv[1]);

            /* 만료 시점 구하기*/
            end[1] += term;
            while(end[1] > 12) {
                end[1] -= 12;
                end[0]++;
            }
            /* 만료 확인 */
            if(todayArr[0] > end[0]) answer.add(i+1);
            else if(todayArr[0] == end[0]) {
                if(todayArr[1] > end[1]) answer.add(i+1);
                else if(todayArr[1] == end[1]) {
                    if(todayArr[2] >= end[2]) answer.add(i+1);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}