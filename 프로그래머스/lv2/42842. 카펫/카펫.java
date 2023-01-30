class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int x=1, y=yellow;
        int min = yellow;
        while(x <= min) {
            if(yellow%x==0){
                int tot = ((x+2)*2)+((y+2)*2)-4;
                if(tot == brown) {
                    answer = new int[]{y+2,x+2};
                    break;
                }
            }
            x++;
            y = yellow/x;
        }
        return answer;
    }
}