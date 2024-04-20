package Arrays.Part_1;

public class BuyandSellStock {
     public static int maxProfit(int[] prices) {
        //Optimal T.C = O(n) and S.C = O(1)
        int min = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    
        //Brute force T.C = O(n ^2) and S.C = O(1)
        // int max = 0;
        // for(int i = 0; i < prices.length; i++){
        //     for(int j = i+1; j < prices.length; j++){
        //         max = Math.max(max, prices[j] - prices[i]);
        //     }
        // }
        // return max;
    }

    public static void main(String[] args){
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }
}
