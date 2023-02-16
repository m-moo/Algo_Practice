class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] arr = Integer.toString(x).split("");
        double tot = 0;
        for(int i=0;i<arr.length;i++){
            tot+=Integer.parseInt(arr[i]);
        }
        answer = x%tot==0;
        return answer;
    }
}