import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        TreeSet<Integer> sums = new TreeSet<>();
        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                sums.add(numbers[i]+ numbers[j]);
            }
        }
        answer = sums.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}