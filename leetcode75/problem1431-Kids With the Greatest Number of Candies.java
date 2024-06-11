/*
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/1284983192/?envType=study-plan-v2&envId=leetcode-75
Pretty easy
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max = candies[0];

        for(int i = 1; i < candies.length; i++){
            max = Math.max(candies[i], max);
        }
        
        //the kid with the most candy is called the candy king
        List<Boolean> candyKing = new ArrayList<Boolean>(); 

        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= max){
                candyKing.add(true);
            }
            else{
                candyKing.add(false);
            }
        }

        return candyKing;
        
    }
}
