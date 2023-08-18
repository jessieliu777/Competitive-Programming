class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0 ) return 0;
       
        int pre_rest=0, curRest=0;
        int pre_buy = -prices[0], curBuy=0;
        int pre_sell = Integer.MIN_VALUE, curSell=0;
        for(int i=1; i<prices.length; i++){
            curRest = Math.max(pre_rest,pre_sell);
            curBuy = Math.max(pre_buy,pre_rest-prices[i]);
            curSell = pre_buy+prices[i];
            
            pre_rest = curRest;
            pre_buy = curBuy;
            pre_sell = curSell;
        }
        return Math.max(curRest,curSell);
    }
}