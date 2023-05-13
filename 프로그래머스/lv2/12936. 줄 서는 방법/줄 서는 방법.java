import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        List<Integer> people = new ArrayList<>();
        long factorial = 1;
        for(int i=1;i<=n;i++) {
            people.add(i);
            factorial *= i;
        }

        k--; // 0부터 시작하기 위해
        for(int i=n;i>0;i--) {
            factorial /= i;
            int idx = (int)(k / factorial);
            answer[n-i] = people.get(idx);
            people.remove(idx);

            k %= factorial;
        }
        return answer;
    }
}