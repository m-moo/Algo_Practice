class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != ' ') {
                int sum = arr[i]+n;
                if(arr[i] <= 'Z') {
                    if(sum > 'Z') {
                        sum = 'A'+(sum-1-'Z');
                    }
                }else{
                    if(sum > 'z') {
                        sum = 'a'+ (sum-1-'z');
                    }
                }
                arr[i]=(char)sum;
            }
        }
        
        return String.valueOf(arr);
    }
}