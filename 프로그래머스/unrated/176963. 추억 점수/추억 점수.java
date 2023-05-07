import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++) map.put(name[i],yearning[i]);

        for(int i=0;i<photo.length;i++) {
            for(int j=0;j<photo[i].length;j++) {
                Integer n = map.get(photo[i][j]);
                if(n != null) answer[i] += n;
            }
        }
        return answer;
    }
}