class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0;i< numbers.length;i++) {
            long n = numbers[i];
            long next = n+1;
            long diff = n ^ next;

            while(Long.bitCount(diff) > 2) {
                next += diff & -diff;
                diff = n ^ next;
            }
            answer[i] = next;
        }
        return answer;
    }
}