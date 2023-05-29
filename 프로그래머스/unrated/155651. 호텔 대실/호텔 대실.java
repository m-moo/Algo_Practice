import java.util.*;

class Solution {
    static final int MAX_TIME = 1450;
    static final int HOUR = 60;
    static final int CLEAN_TIME = 10;
    
    public int solution(String[][] book_time) {
        int answer = 0;

        int[] rooms = new int[MAX_TIME];

        for(String[] time:book_time) {
            rooms[calcTime(time[0])] += 1;
            rooms[calcTime(time[1]) + CLEAN_TIME] -= 1;
        }

        /* 누적합 */
        for(int i=1;i<MAX_TIME;i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }
    
    public int calcTime(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0])*HOUR + Integer.parseInt(timeArr[1]);
    }
}