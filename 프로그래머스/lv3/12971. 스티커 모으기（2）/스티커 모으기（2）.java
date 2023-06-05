class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        /* 첫번째 스티커 사용 */
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i=2;i<sticker.length-1;i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
        }
        /* 마지막 스티커 사용 */
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2;i<sticker.length;i++) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }
        return Math.max(dp1[sticker.length-2],dp2[sticker.length-1]);
    }
}