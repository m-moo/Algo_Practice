class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<food.length;i++) {
            if(food[i]>1) {
                int cnt = food[i]/2;
                while(cnt!=0){
                    sb.append(i);
                    cnt--;
                }
            }
        }
        StringBuffer front = new StringBuffer(sb);
        answer = front.append(0).append(sb.reverse()).toString();
        
        return answer;
    }
}