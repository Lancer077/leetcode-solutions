/*
https://leetcode.com/problems/find-the-highest-altitude/description
https://leetcode.com/problems/find-the-highest-altitude/submissions/1288404959
Despite being a very easy problem, I enjoyed it. It was finally nice to see leetcode actually making their 'easy' problems easy
*/

class Solution {
    public int largestAltitude(int[] gain) {

        int curHeight = 0;
        int maxHeight = 0;

        for(int i = 0; i < gain.length; i++){
            curHeight = curHeight + gain[i];

            if(curHeight > maxHeight){
                maxHeight = curHeight;
            }
        }

        return maxHeight;
        
    }
}
