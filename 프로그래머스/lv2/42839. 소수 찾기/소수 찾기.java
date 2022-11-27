import java.util.HashSet;

class Solution {
    HashSet<Integer> numSet = new HashSet<Integer>();
    
    public int solution(String numbers) {
        int answer = 0;
        combination("", numbers);

        for(Integer n:numSet) {
            if(isPrime(n)) answer++;
        }
        return answer;
    }

    public void combination(String input, String left) {
        if(!input.equals("")) numSet.add(Integer.parseInt(input));

        for(int i=0;i<left.length();i++) {
            combination(input+left.charAt(i),
                    left.substring(0,i)+left.substring(i+1));
        }
    }

    public boolean isPrime(int n) {
        if(n<=1) return false;
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}