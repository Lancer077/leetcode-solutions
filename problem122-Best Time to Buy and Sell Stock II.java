//Pretty fun problem, went at it with sort of a calculus approach similar to derivatives.
//1ms runtime and 45.43 mb of memory
class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        boolean holdingShare = false; //we start off not holding a stock
        int boughtPrice = 0; //create boughtPrice here for scope reasons that will become apparent on line 36

        //plan: buy low, right before prices start increasing and sell high, right before prices start going back down
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[i-1]){ //if prices going down

                //sell before prices go down
                if(holdingShare){
                    holdingShare = false;
                    totalProfit = totalProfit + (prices[i-1] - boughtPrice);
                    boughtPrice = 0; //reset bought price
                    //we sell for the highest value before the stock went down
                }

                //if we are not holding a share then we do nothing, and wait for the stock to start going back up again
            }

            else if(prices[i] > prices[i-1]){ //if prices going up
                //if we do not already own the stock, then we want to buy
                if(!holdingShare){
                    holdingShare = true; //buy
                    boughtPrice = prices[i-1]; //buy at the lower price
                }
                //if we already own the stock, we wait until the stock gets the highest value
            }
        }
        //if we still own a stock at the end, we will sell it for the ending value in the list
        if(holdingShare){
            holdingShare = false;
            totalProfit = totalProfit + (prices[prices.length-1] - boughtPrice);
        }

        return totalProfit;
    }
}
