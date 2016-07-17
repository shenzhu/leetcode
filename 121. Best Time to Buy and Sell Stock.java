public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;      // corner case

        int maxCurr = 0;        // current maximum value
        int maxSoFar = 0;       // maximum value found so far
        for(int i = 1; i < prices.length; i++){
            maxCurr = Math.max(0, maxCurr += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }
        return maxSoFar;
    }
}

public class Solution{
    public int maxProfit(int[] prices){
        if(prices == null || prices.length == 0) return 0;

        int maxCurr = 0;
        int maxSoFar = 0;
        for(int i = 1; i < prices.length; i++){
            maxCurr = Math.max(0, maxCurr += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }

        return maxSoFar;
    }
}