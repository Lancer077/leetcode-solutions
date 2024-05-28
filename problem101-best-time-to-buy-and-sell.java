//runtime was 1ms on the test cases, beat 99.73% of java users
//61.58 mb of storage, beat 53.81% of java users
//overall I found this one to be really fun with a super elegant solution in O(n) and not O(n^2) as I believed it would have been at first
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];

        for(int i = 0; i < prices.length; i++){
            //check for local minimum
            if(prices[i] < min){
                min = prices[i]; //update local minimum
            }

            //check for difference in prices
            if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
