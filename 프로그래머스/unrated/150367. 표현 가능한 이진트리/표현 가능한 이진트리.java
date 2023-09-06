class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];

        for(int i=0;i<len;i++) {
            String bin = Long.toBinaryString(numbers[i]);

            int cnt = 1;
            while(Math.pow(2,cnt)-1 < bin.length()) cnt++;
            while(Math.pow(2,cnt)-1 != bin.length()) {
                bin = "0"+bin;
            }

            if(check(bin)) answer[i] = 1;
        }
        return answer;
    }

    public boolean check(String bin) {
        boolean valid = true;

        int mid = bin.length()/2;
        char root = bin.charAt(mid);
        String left = bin.substring(0,mid);
        String right = bin.substring(mid+1,bin.length());

        if(root == '0' && (left.charAt(left.length()/2) == '1' ||
            right.charAt(right.length()/2) == '1')) {
            return false;
        }

        if(left.length() >= 3) {
            valid = check(left);
            if(valid) valid = check(right);
        }
        return valid;
    }
}