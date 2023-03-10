class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();

        int[][] pad = {{3,1},
                {0,0},{0,1},{0,2},
                {1,0},{1,1},{1,2},
                {2,0},{2,1},{2,2},
                {3,0},{3,1},{3,2}
        };
        int left = 10, right = 12;
        String curr = "";

        for(int i=0;i< numbers.length;i++) {
            int n = numbers[i];
            switch (n) {
                case 1: case 4: case 7:
                    curr = "L";
                    left = n;
                    break;
                case 3: case 6: case 9:
                    curr = "R";
                    right = n;
                    break;
                default :
                    int[] target = {pad[n][0],pad[n][1]};
                    int l = Math.abs(pad[left][0] - target[0])+Math.abs(pad[left][1] - target[1]);
                    int r = Math.abs(pad[right][0] - target[0])+Math.abs(pad[right][1] - target[1]);

                    if(l > r) {
                        curr = "R";
                        right = n;
                    }else if(l < r){
                        curr = "L";
                        left = n;
                    }else{
                        if(hand.equals("right")){
                            curr = "R";
                            right = n;
                        }else{
                            curr = "L";
                            left = n;
                        }
                    }
            }
            answer.append(curr);
        }
        return answer.toString();
    }
}