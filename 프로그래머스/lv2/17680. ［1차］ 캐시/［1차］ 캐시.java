import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return cities.length*5;

        List<String> cache = new ArrayList<>();
        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toLowerCase();
            int idx = cache.indexOf(city);

            if(idx < 0) { // 캐시에 없는 경우
                answer += 5;
                if(cache.size() == cacheSize){ // 캐시가 꽉 찼다면 LRU item 삭제
                    cache.remove(0);
                }
            }else {
                answer++;
                cache.remove(idx);
            }
            cache.add(city);
        }
        return answer;
    }
}