import java.util.HashMap;

class Solution {
    HashMap<String,String> ref = new HashMap<>();
    HashMap<String,Integer> num = new HashMap<>();
    int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            num.put(enroll[i],i);
            ref.put(enroll[i],referral[i]);
        }

        /* 판매량 계산 */
        for(int i=0;i<seller.length;i++){
            String s = seller[i];
            int money = amount[i]*100;
            int refMoney = money/10;

            answer[num.get(s)] += money - refMoney;
            String refSeller = ref.get(s);
            giveRefMoney(ref.get(s), refMoney);
        }
        
        return answer;
    }
    
    public void giveRefMoney(String s, int mon) {
        if(!s.equals("-")){
            int refMoney = mon/10;
            answer[num.get(s)] += mon-refMoney;
            if(refMoney==0) return;
            giveRefMoney(ref.get(s), refMoney);
        }
    }
}