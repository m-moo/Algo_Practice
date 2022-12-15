import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = {};
        Integer nums[] = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff1 = Math.abs(n-o1);
                int diff2 = Math.abs(n-o2);
                if(diff1==diff2) {
                    return o2-o1;
                }
                return diff1-diff2;
            }
        });
        
        answer = Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}