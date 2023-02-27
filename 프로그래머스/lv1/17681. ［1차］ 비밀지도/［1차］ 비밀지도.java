class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0;i<arr1.length;i++) {
            String bin = Integer.toBinaryString(arr1[i]|arr2[i]);
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<n-bin.length();j++) {
                sb.append(" ");
            }
            sb.append(bin.replaceAll("1","#").replaceAll("0"," "));
            answer[i] = sb.toString();
        }
        return answer;
    }
}