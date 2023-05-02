import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=1;i<=len;i++) {
            for(int j=0;j<len;j++) {
                int tot = 0;
                for(int k=j;k<j+i;k++) {
                    tot += elements[k%len];
                }
                set.add(tot);
            }
        }
        return set.size();
    }
}