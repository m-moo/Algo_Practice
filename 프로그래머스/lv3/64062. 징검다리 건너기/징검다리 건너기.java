import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int low = 1, high = Arrays.stream(stones).max().getAsInt();
        int mid = 0;

        while(low<=high) {
            mid = (low+high)/2;
            if(isPossible(stones,mid,k)) {
                answer = mid;
                low = mid+1;
            }else high = mid-1;
        }

        return answer;
    }

    public boolean isPossible(int[] stones, int mid, int k) {
        int cnt = 0;
        for(int s:stones) {
            if(s - mid < 0) cnt++;
            else cnt = 0;
            if(cnt >= k) return false;
        }
        return true;
    }
}