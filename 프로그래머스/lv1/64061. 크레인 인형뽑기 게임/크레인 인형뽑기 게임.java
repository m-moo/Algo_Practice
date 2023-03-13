import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int[] idxArr = new int[board[0].length];
        Stack<Integer> basket = new Stack<>();

        for(int i=0;i<moves.length;i++) {
            int n = moves[i]-1;
            int doll = 0;
            /* 인형까지 크레인 내리기 */
            for(int j=idxArr[n];j<board[n].length;j++) {
                doll = board[idxArr[n]++][n];
                if(doll != 0) break;
            }
            if(doll != 0){
                if(!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer+=2;
                }else basket.add(doll);
            }
        }
        
        return answer;
    }
}