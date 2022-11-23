class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,target,0);

        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int total) {
        if(numbers.length == depth) {
            if(target == total) answer++;
        }else{
            dfs(numbers,depth+1,target,total+numbers[depth]);
            dfs(numbers,depth+1,target,total-numbers[depth]);
        }
    }
}