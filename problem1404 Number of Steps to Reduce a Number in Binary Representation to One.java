/*
After doing this one, I know I did not do it in the most efficient way, but this was my stumbling around in the dark trying to figure things out.
Although it was only a medium problem, I was at first dissuaded from trying it due to the percieved difficulty, however I am glad I stuck with it, even if my final submission was not impressive to the leetcode leaderboards.
As I always tell myself and others: Rarely does anyone write good code on their first try, especially for any sort of complex system.

*/

class Solution {
    /** 
    My thought process for this one goes as follows:
    If the last character in the string is a zero, that means we have an even number and we can just divide by two by just getting the substring of the string without the last character.
    This strategy was made possible by base two and viewers like you. Thank You! (I Couldn't help the PBS reference).

    If the last character in the string is a 1, then we are dealing with an odd number and we need to add 1. Now what happens if we have a string that is like 1011, we then need to turn it into 1100, so my plan is to take the string, find the last zero (aka the least significant zero) and replace that zero with a 1. Now I change all the 1s to the right of the zero to zeros. I hope I'm making sense here but I doubt it.

    "If you can't provide a helpful comment, at least provide a funny one." -Mason Myre
    
     */
    public int numSteps(String s) {
        
        int stepTotal = 0; //running counter for number of steps

        char lastChar; //not necessary but storing the last character in a variable instead of using charAt every time is nice to have

        while(!s.equals("1")){ //this ensures we run until we have a solution
            stepTotal++;

            lastChar = s.charAt(s.length()-1); //grab the last character

            if(lastChar == '0'){ //if we have an even number, we divide by two.
                s = s.substring(0, s.length() - 1); //in base 2, to divide by two, we can just remove the least significant character, and shift all other numbers one spot to the right

            }

            else if(lastChar == '1'){
                s = addOne(s);
            }

        }

        return stepTotal;
    }

    public String addOne(String s){
        boolean found = false; //if the input string is 1111111, this will never be set to true, and we will do a little trickery (vaguely intelligent idea) to solve the problem
        int iterator = s.length();
        String s1; //A surprise tool that will help us later
        String s2; //Lets me break up the string into a before the last zero and after the last zero
        char c;
        while(iterator > 0 && !found){ //this no works

            iterator--;
            c = s.charAt(iterator);

            if(c == '0'){
                found = true;
                s1 = s.substring(0, iterator); //lemme break it down for you
                s2 = s.substring(iterator + 1, s.length());
                s2 = s2.replace("1", "0");

                s = s1 + "1" + s2; //putting it back together
                break;
            }

        }

        if(!found){//this works
            s = s.replace("1", "0");
            s = "1" + s;
        }

        return s;

    }



}
