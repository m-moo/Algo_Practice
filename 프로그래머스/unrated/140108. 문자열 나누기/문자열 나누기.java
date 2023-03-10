class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        char start = arr[0];
        int diff = 0;

        for(int i=0;i<arr.length;i++) {
            if (start != arr[i]) diff--;
            else diff++;

            if(i==arr.length-1) answer++;
            else{
                if(diff == 0) {
                    answer++;
                    start = arr[i + 1];
                }
            }
        }
        
        return answer;
    }
}