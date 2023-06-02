import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        while(j < B.length) {
            if(A[i] < B[j]) {answer++; i++;}
            j++;
        }

        return answer;
    }
}