class Solution {
    public int solution(int n, int[] money) {
        int[] ways = new int[n+1];
        ways[0] = 1;

        for(int coin:money) {
            for(int i=coin;i<=n;i++) {
                ways[i] += ways[i-coin];
            }
        }
        return ways[n]%1000000007;
    }
}