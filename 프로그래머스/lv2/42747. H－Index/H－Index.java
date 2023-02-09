import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);

        int len = citations.length;
        for(int i=0;i<len;i++) {
            int h = len-i;

            if (citations[i]>=h){
                hIndex = h;
                break;
            }
        }
        
        return hIndex;
    }
}