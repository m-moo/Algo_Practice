import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, List<String>> rMap = new HashMap<>();
        HashMap<String,Integer> reported = new HashMap<>();
        for(int i=0;i<report.length;i++) {
            String[] r = report[i].split(" ");
            List<String> mapList = rMap.getOrDefault(r[0], new ArrayList<>());
            if(!mapList.contains(r[1])) {
                mapList.add(r[1]);
                rMap.put(r[0], mapList);
                reported.put(r[1],reported.getOrDefault(r[1],0)+1);
            }
        }

        for(int i=0;i<id_list.length;i++){
            String id = id_list[i];
            List<String> mapList = rMap.get(id);
            if (mapList != null) {
                for(int j=0;j<mapList.size();j++) {
                    if(reported.get(mapList.get(j)) >= k) answer[i]++;
                }
            }
        }
        return answer;
    }
}