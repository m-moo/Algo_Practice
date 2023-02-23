import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            public int compareMore(String o1, String o2, int idx) {
                char c1 = o1.charAt(idx), c2 = o2.charAt(idx);
                if(c1 > c2) return 1;
                else if(c1 < c2) return -1;
                else return compareMore(o1,o2,idx+1);
            }

            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n), c2 = o2.charAt(n);

                if(c1 > c2) return 1;
                else if(c1 < c2) return -1;
                else return compareMore(o1,o2,0);
            }
        });
        return strings;
    }
}