/*
https://leetcode.com/problems/removing-stars-from-a-string/description/
https://leetcode.com/problems/removing-stars-from-a-string/submissions/1302222800/

My crazy idea worked out pretty well, I figured if I have to go back anyways due the stars, why not just do the whole thing backwards.
So I reversed the string.
I had never used the stringbuilder extensively before so I went to look up how to reverse a stringbuilder and saw the result for stringbuilder.reverse()
StringBuilder just might be one of my new favorite libraries going forward.
Not to brag or anything but first submission accepted, 10 minutes spent, and 93% of other java coders clowned on.
But totally not bragging or anything.

*/

class Solution {
    public String removeStars(String s) {
        //gentlemen, I may not have a brain but I have an idea
        //reverse string->do the removals going forward->unreverse the string

        //I'm either brilliant or stupid but at least I'm not average

        int starCounter = 0; //sounds so much cooler than it actually is

        StringBuilder reversed = new StringBuilder(s.length()); //new stringbuilder with capacity of original string

        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '*'){ //if the next character is a star
                starCounter++; //increment StarCounter TM
            }
            else if(starCounter > 0){ //if star removes the character, just don't add that character to the string builder
                starCounter--;
            }
            else{
                reversed.append(s.charAt(i)); //if starCounter==0, add the character
            }
        }
        
        return reversed.reverse().toString(); //now cha-cha real smooth
        
    }
}
