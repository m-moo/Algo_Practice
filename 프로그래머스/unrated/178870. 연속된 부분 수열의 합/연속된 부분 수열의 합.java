class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,sequence.length};

        int start = 0, end = 0;
        int tot = sequence[0];
        while(end < sequence.length) {
            if(tot < k) { // 목표값보다 작으면 end 포인터 전진
                end++;
                if (end < sequence.length) tot += sequence[end];
            } else {
                if(tot == k && answer[1]-answer[0] > end-start) {
                    /* 목표값일 경우 이전 수열의 길이를 비교하여 정답 갱신 */
                    answer[0] = start;
                    answer[1] = end;
                }
                /* 다른 경우를 찾기 위해 start 포인터 전진 */
                tot -= sequence[start];
                start++;
            }
        }
        return answer;
    }
}