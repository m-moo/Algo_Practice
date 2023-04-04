class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];

        for(int i=1;i<arr.length;i++) {
            int a  = arr[i-1], b = arr[i];
            if(b%a == 0) arr[i] = b;
            else arr[i] = a*b/getGCF(a,b);
        }
        
        return arr[arr.length-1];
    }
    
    public int getGCF(int a, int b) {
        int rs = 1;
        int cnt = 2;
        while(cnt <= a/2) {
            if(a%cnt == 0 && b%cnt == 0) {
                a/=cnt;
                b/=cnt;
                rs*=cnt;
                cnt = 2;
            }else cnt++;
        }
        return rs;
    }
}