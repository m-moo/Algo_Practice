class Solution {
    /* 키패드 */
    int[][] pad = {{3,1},
            {0,0},{0,1},{0,2},
            {1,0},{1,1},{1,2},
            {2,0},{2,1},{2,2}
    };
    /* 엄지 위치 */
    int[] left = {3,0};
    int[] right = {3,2};
    String hand;
    
    public String solution(int[] numbers, String hand) {
        this.hand = String.valueOf(Character.toUpperCase(hand.charAt(0)));
        StringBuffer answer = new StringBuffer();

        for(int i=0;i< numbers.length;i++) {
            int n = numbers[i];

            String thumb = pushNumber(n);
            answer.append(thumb);
            /* 손가락 위치 옮기기*/
            if(thumb.equals("R")) right = pad[n];
            else left = pad[n];
        }
        return answer.toString();
    }
    
    public String pushNumber(int n) {
        if(n==1 || n==4 || n==7) return "L";
        if(n==3 || n==6 || n==9) return "R";

        /* 손가락 움직임 계산 */
        int[] target = {pad[n][0],pad[n][1]};
        int l = Math.abs(left[0] - target[0])+Math.abs(left[1] - target[1]);
        int r = Math.abs(right[0] - target[0])+Math.abs(right[1] - target[1]);

        if(l > r)  return "R";
        else if(l < r) return "L";
        else{
            return this.hand;
        }
    }
}