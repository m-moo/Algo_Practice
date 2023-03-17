class Solution {
    String[] keymap;

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        this.keymap = keymap;
        for(int i=0;i<targets.length;i++) {
            int sum = pushBtn(targets[i]);
            
            if(sum == 0) sum = -1;
            answer[i] = sum;
        }
        
        return answer;
    }
    
    public int pushBtn(String t) {
        int sum = 0;
        for(int i=0;i<t.length();i++) {
            int min = 0;
            char c = t.charAt(i);
            for(int j=0;j<keymap.length;j++) {
                int idx = keymap[j].indexOf(c);

                if(min != 1 && idx > -1) {
                    if(min == 0) min = idx+1;
                    else min = Math.min(min,idx+1);
                }
            }
            if(min == 0) return 0;
            sum+=min;
        }
        return sum;
    }
}