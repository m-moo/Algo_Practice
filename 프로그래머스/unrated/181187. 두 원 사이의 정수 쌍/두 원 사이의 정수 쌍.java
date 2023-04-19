class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long dot1 = 0, dot2 = 0;

        /* r1과 r2의 점 개수 구하기 */
        for(long x=1;x<r2;x++) {
            dot2 += getDots(r2,x,true);
            if(x < r1){
                dot1 += getDots(r1,x,false);
            }
        }

        /* r2에서 r1의 점을 빼서 사잇값을 구함함 */
        answer = (dot2 - dot1) * 4;
        answer += (r2 - r1 + 1)*4;
        return answer;
    }
    public int getDots(long r, long x, boolean isR2) {
        double num = Math.sqrt(r*r - x*x);
        /* r1의 경우 정수로 떨어지면 사잇값에 포함해야 한다  */
        if(!isR2) return (int)(num%1>0?num:num-1);
        else return (int)num;
    }
}