/*
https://leetcode.com/problems/find-center-of-star-graph/description/
https://leetcode.com/problems/find-center-of-star-graph/submissions/1302163161/

I'm still waiting for the catch here. I know it's classified as an easy but this was truly trivial.
Thank you leetcode gods for letting me get 10 points closer to that leetcode hat.
*/

class Solution {
    public int findCenter(int[][] edges) {
        //this seems suspiciously easy
        int a = edges[0][0]; //(probably) faster to just store the int than to traverse back through the array 

        if(a == edges[1][0] || a == edges[1][1]){return a;} //if the first number is found in the second array, return the first number
        return edges[0][1]; //otherwise return the second number

    }
}
