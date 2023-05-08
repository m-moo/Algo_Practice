import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        /* fees: 기본 시간, 기본 요금, 단위 시간, 단위 요금*/

        HashMap<String, Integer> inMap = new HashMap<>();
        HashMap<String, Integer> timeMap = new HashMap<>();
        for(int i=0;i< records.length;i++) {
            String[] info = records[i].split(" ");
            String time = info[0], carNum = info[1], type = info[2];
            int timeInMin = Integer.parseInt(time.split(":")[0]) * 60
                    + Integer.parseInt(time.split(":")[1]);

            if(type.equals("IN")) inMap.put(carNum,timeInMin);
            else {
                int parkedTime = timeInMin - inMap.get(carNum);
                inMap.remove(carNum);
                timeMap.put(carNum,timeMap.getOrDefault(carNum,0)+parkedTime);
            }
        }

        /* 출차 기록이 없는 차 */
        for(String carNum : inMap.keySet()) {
            int parkedTime = 1439 - inMap.get(carNum); // 23:59 = 1439
            timeMap.put(carNum, timeMap.getOrDefault(carNum,0)+parkedTime);
        }

        /* 차량 번호 정렬 */
        ArrayList<String> carNums = new ArrayList<>(timeMap.keySet());
        Collections.sort(carNums);

        int[] answer = new int[carNums.size()];

        for(int i=0;i< answer.length;i++) {
            int parkedTime = timeMap.get(carNums.get(i));
            int fee = fees[1];

            if(parkedTime > fees[0]) {
                fee += Math.ceil((double)(parkedTime - fees[0]) / fees[2]) * fees[3];
            }
            answer[i] = fee;
        }
        return answer;
    }
}