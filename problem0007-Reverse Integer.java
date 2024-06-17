/*
They call me 0007: 0% beat on time, 0% beat on space, 0% sanity, 7 attempts at a solution.
In all seriousness, I had tried this problem a before about a week or so ago and I was completely lost to figure out a solution that didn't involve turning the int to a string, turning the string into a 
  char array, reversing the char array, turning that char array into a string, and finally turning that string back into an integer. I would have rather changed majors than do that so I took a break from 
  the problem and came back when I had more experience. The 'attempted' mark that leetcode was dangling in front of my face was enough to make me test my mettle again today and I finally got it.
I had definitely felt like my time spent here on leetcode was making me a better programmer, but this was the first time I could actually see the difference my experience here has made.
Although my solution definitely wasn't the fastest, it worked and it worked reasonably well, tying or beating 76% of other submissions for speed efficiency.
Working through these problems, I've definitely felt my improvement and it feels like a good analogy would be that I started out as a mechanic with only an adjustable wrench, needing to take time 
  to change my approach and mindset to different problems, to a mechanic with a wrench set, or experience with certain problem types that I can apply to similar problems.
https://leetcode.com/problems/reverse-integer/description/
https://leetcode.com/problems/reverse-integer/submissions/1291724623/
*/

class Solution {
    public int reverse(int x) {

        boolean negative = false; //determine if we need to add a negative to the return value

        if(x < 0){ 
            negative = true;
            x = x * -1; //negatives would mess with the stack so we deal with them at the end
        }

        int lastInt; //overflow checker

        int reversed = x % 10;
        lastInt = x; //way to check for overflow
        x = x / 10;
        

        while(x != 0){ //while there is another number to grab
            reversed = (reversed * 10) + x % 10;
            lastInt = x; //way to check for overflow
            x = x / 10; //go to the next
        }

        if(reversed % 10 != lastInt){ //checking for integer overflow
            return 0;
        }

        if(negative){reversed = reversed * -1;}
        
        return reversed;
    }
}
