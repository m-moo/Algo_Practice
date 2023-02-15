import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length==1) return new int[]{-1};

        int min = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[min] > arr[i]) min = i;
        }
        final int item = min;
        answer = Arrays.stream(arr).filter(i -> i!=arr[item]).toArray();
        return answer;
    }
}