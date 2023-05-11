class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] piramid = new int[n][];

        /* 피라미드 초기화 */
        for(int i=0;i<n;i++) piramid[i] = new int[i+1];

        int num = 1;
        int row = -1, col = 0;
        while(n>0) {
            for(int i=0;i<n;i++) piramid[++row][col] = num++;
            for(int i=1;i<n;i++) piramid[row][++col] = num++;
            for(int i=2;i<n;i++) piramid[--row][--col] = num++;
            n-=3;
        }

        int cnt = 0;
        for(int[] arr:piramid) {
            for(int a:arr) {
                answer[cnt++] = a;
            }
        }
        return answer;
    }
}