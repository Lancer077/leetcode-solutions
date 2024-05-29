/*
https://leetcode.com/problems/length-of-last-word/?envType=daily-question&envId=2024-05-29
Since this was considered an easy problem, I wanted to make the most efficient solution possible. 
The only real optimization I could tell was starting at the end and traversing backwards, as well as trying to use the fewest checks as possible.
*/
class Solution {
    public int lengthOfLastWord(String s) {
        boolean wordStarted = false;
        int counter = 0;

        for(int i = s.length()-1; i >= 0; i--){

            if(s.charAt(i) != ' '){ //if we have a character
                
                wordStarted = true; //is it faster to just reassign wordStarted as true or to check and then reassign?
                //if we assume assigning and checking both take the same time then checking is slower because it needs to do the checking plus the 1 assignment whereas assigning just has to do the assigning
                //but it's probably just splitting hairs at this point
                counter++; //increment counter

            }

            else{ //if we have a space, this could either mean its before or after the last word
                if(wordStarted){ //check if a word has been started
                    return counter; //if so, then this is the end of the word and we return the counter value
                } //otherwise it is just a padding space and we do nothing
            }

        }
        return counter;
    }
}
