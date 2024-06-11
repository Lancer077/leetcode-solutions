/*
At the recommendation of a coworker, I was told to start the leetcode 75 (probably just because he wanted to see someone else suffer in problem 0739-Daily Temperatures just like he did)
This was the first one and it was trivial. I realized the way leetcode does the 'beats x% of users' makes sense to include the ones you tied with because if you come up with the best solution that everyone
  else was able to come up with, there is no reason to punish you for the fact that others could do it just as fast.
Another thing, since the JVM can create inconsistencies with how much space is used, maybe 
https://leetcode.com/problems/merge-strings-alternately/description/
Not much interesting going on with this problem, but my solution tied for or beat 85% of users in runtime at 1ms, beat or tied 77% of users in space efficiency
Gonna start copy/pasting my submissions and not just the problem description
https://leetcode.com/problems/merge-strings-alternately/submissions/1284964517/?envType=study-plan-v2&envId=leetcode-75
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder merged = new StringBuilder();

        int index = 0;

        int min = Math.min(word1.length(), word2.length());
        int diff = word1.length() - word2.length(); //positive: word 1 longer, negative: word 2 longer, zero: equal lengths
        boolean flip = true; //true means word1, false means word2


        while(index < min){
            if(flip){
                merged.append(word1.charAt(index));
                flip = false;
            }
            if(!flip){
                merged.append(word2.charAt(index));
                flip = true;
                index++;
            }

        }

        if(diff > 0){
            merged.append(word1.substring(index, word1.length()));
        }
        else if(diff < 0){
            merged.append(word2.substring(index, word2.length()));
        }

        return merged.toString();
        

    }
}
