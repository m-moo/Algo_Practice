class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i=1;i<triangle.length;i++) {
            int gradeLen = triangle[i].length;
            for(int j=0;j<gradeLen;j++) {
                int curr = triangle[i][j];
                int max = curr;
                if(j != 0) max = Math.max(max,curr+triangle[i-1][j-1]);
                if(j != gradeLen-1) max = Math.max(max,curr+triangle[i-1][j]);

                triangle[i][j] = max;
                if(i == triangle.length-1) answer = Math.max(answer,triangle[i][j]);
            }
        }
        return answer;
    }
}