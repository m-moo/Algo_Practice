import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;

        int curr = n;
        while(curr != 1){
            ans += curr%2;
            curr /= 2;
        }

        return ans;
    }
}