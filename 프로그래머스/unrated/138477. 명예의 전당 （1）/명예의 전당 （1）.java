import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        int min = 0;
        for(int i=0;i< score.length;i++) {
            list.add(score[i]);
            list.sort(Comparator.reverseOrder());
            if(list.size() > k-1) min =list.get(k-1);
            else min = list.get(i);
            answer[i] = min;
        }
        
        return answer;
    }
}