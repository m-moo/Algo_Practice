import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> stars = new ArrayList<>();

        long xMin = Long.MAX_VALUE, xMax = Long.MIN_VALUE;
        long yMin = Long.MAX_VALUE, yMax = Long.MIN_VALUE;
        for(int i=0;i<line.length-1;i++){
            int[] line1 = line[i];
            for(int j=i+1;j< line.length;j++){
                int[] line2 = line[j];
                long a = line1[0], b = line1[1], e = line1[2];
                long c = line2[0], d = line2[1], f = line2[2];
                long dn = (a*d)-(b*c);
                if(dn!=0){
                    /* x,y가 정수일 경우에만 별로 취급 */
                    if(((b*f)-(e*d))%dn==0 && ((e*c)-(a*f))%dn==0){
                        /* 교점 구하기 */
                        long x = ((b*f)-(e*d)) / dn;
                        long y = ((e*c)-(a*f)) / dn;
                        
                        xMin = Math.min(x,xMin);
                        xMax = Math.max(x,xMax);
                        yMin = Math.min(y,yMin);
                        yMax = Math.max(y,yMax);
                        stars.add(new long[]{x, y});
                    }
                }
            }
        }

        StringBuilder[] rs = new StringBuilder[(int)(yMax-yMin)+1];
        for(int i=0;i<rs.length;i++){
            rs[i] = new StringBuilder();
            for(int j=0;j<=(int)(xMax-xMin);j++){
                rs[i].append('.');
            }
        }
        for(int i=0;i<stars.size();i++){
            long[] star = stars.get(i);
            int y =(int)(yMax-star[1]);
            int x = (int)(star[0]-xMin);
            rs[y].replace(x,x+1,"*");
        }

        answer = new String[rs.length];
        for(int i=0;i<rs.length;i++){
            answer[i] = rs[i].toString();
        }
        return answer;
    }
}