import java.util.ArrayList;

class Solution {
    ArrayList<Long> numList;
    ArrayList<String> opList;

    long answer = 0;
    char[] ops = {'*','+','-'};
    char[] priority = new char[3];
    boolean[] visited = new boolean[3];
    
    public long solution(String expression) {
                numList = new ArrayList<>();
        opList = new ArrayList<>();

        /* 숫자, 연산자 분리 */
        String num = "";
        for(int i=0;i<expression.length();i++) {
            char c = expression.charAt(i);

            if(c - '0' >= 0) num+=c;
            else {
                numList.add(Long.parseLong(num));
                opList.add(String.valueOf(c));
                num = "";
            }
        }
        numList.add(Long.parseLong(num));

        backTrack(0);
        return answer;
    }
    
    public void backTrack(int depth) {
        if(depth == 3) {calculate(); return;}

        for(int i=0;i<3;i++) {
            if(!visited[i]) {
                visited[i] = true;
                priority[depth] = ops[i];
                backTrack(depth+1);
                visited[i] = false;
            }
        }
    }

    public void calculate() {
        ArrayList<String> tmpOpList = new ArrayList<>(opList);
        ArrayList<Long> tmpNumList = new ArrayList<>(numList);

        for(int i=0;i< priority.length;i++) {
            String op = String.valueOf(priority[i]);
            for(int j=0;j< tmpOpList.size();j++) {
                if(op.equals(tmpOpList.get(j))) {
                    Long rs = calc(tmpNumList.remove(j), tmpNumList.remove(j), op);
                    tmpNumList.add(j,rs);
                    tmpOpList.remove(j);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(tmpNumList.get(0)));
    }

    public Long calc(Long n1, Long n2, String op) {
        if(op.equals("+")) return n1+n2;
        if(op.equals("-")) return n1-n2;
        if(op.equals("*")) return n1*n2;
        else return (long)0;
    }
}