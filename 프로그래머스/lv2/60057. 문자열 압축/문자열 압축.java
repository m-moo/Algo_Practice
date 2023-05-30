class Solution {
    public int solution(String s) {
        int answer = s.length();

        int range = s.length()/2;
        while(range > 0) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String pre = s.substring(0,range);
            for(int i=range,j=i+range;i<s.length();i+=range,j+=range) {
                if(j > s.length()) j = s.length();
                String curr = s.substring(i,j);
                if(curr.equals(pre)) count++;
                else{
                    if(count>1) sb.append(count);
                    sb.append(pre);
                    count = 1;
                }
                pre = curr;
            }
            if(count>1) sb.append(count);
            sb.append(pre);

            answer = Math.min(answer,sb.length());
            range--;
        }

        return answer;
    }
}