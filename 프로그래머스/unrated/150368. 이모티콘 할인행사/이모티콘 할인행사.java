import java.util.ArrayList;
import java.util.List;

class Solution {
    class Emoticon {
        double price;
        double percent;

        public Emoticon(double price, double percent) {
            this.price = price;
            this.percent = percent;
        }
    }

    double[] sales = {0.9, 0.8, 0.7, 0.6};
    int[][] users;
    int maxPlus = 0, maxPrice = 0;
    List<Emoticon> saleEmoList = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        backTrack(0, emoticons);
        return new int[]{maxPlus, maxPrice};
    }

    public void backTrack(int depth, int[] emoticons) {
        if(depth == emoticons.length) {
            purchase();
            return;
        }

        for(int i=0;i<sales.length;i++) {
            saleEmoList.add(new Emoticon(sales[i]*emoticons[depth], 100-sales[i]*100));
            backTrack(depth+1, emoticons);
            saleEmoList.remove(saleEmoList.size()-1);
        }
    }

    public void purchase() {
        int plus = 0;
        int totPrice = 0;
        for(int i=0;i<users.length;i++) {
            int percentLimit = users[i][0];
            int priceLimit = users[i][1];

            int purchased = 0;
            for(int j=0;j<saleEmoList.size();j++) {
                Emoticon emo = saleEmoList.get(j);
                double price = emo.price;
                double percent = emo.percent;
                if(percent >= percentLimit) {
                    purchased += price;
                }
            }

            if(purchased >= priceLimit) {
                plus++;
            }else {
                totPrice += purchased;
            }

            if(maxPlus < plus) {
                maxPlus = plus;
                maxPrice = totPrice;
            }else if(maxPlus == plus && maxPrice < totPrice) {
                maxPrice = totPrice;
            }
        }
    }
}