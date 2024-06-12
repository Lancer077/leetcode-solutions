/*
Very easy problem especially for one considered medium difficulty, or at least that is what I thought before I hit submit for my first solution and realized
  that I was in the lower 12% for time efficiency, and not doing much better in terms of space efficiency
My first idea was to use a stack, so when I put all of the words in, I could just take them out in a reversed order.
Very simple and easy to read, but it also took 15ms. 
I wasn't satisfied with this solution being so obviously bad and since I felt the problem was pretty easy, I set out to optimize as best as I could.
I realized that the stack solution was theoretically o(n) but in practice, since I had to pass through the word list twice o(2n), I could make improvements.
I changed the stack approach to a single pass through (now actually o(n)) and saw an instant speed boost.
Eventually I played around with different ways to check if a string was empty and settled on != "" as I saw a tiny space improvement over the String.isEmpty() function
Also implemented a Stringbuilder and returned that at the end instead of doing something like s = s + " " + tokens[i].
Overall, I enjoyed this problem not for the difficulty of the solution, but for what I was able to learn about java string efficiency.
https://leetcode.com/problems/reverse-words-in-a-string/
https://leetcode.com/problems/reverse-words-in-a-string/submissions/1286074061/
*/
class Solution {
    public String reverseWords(String s) {

        StringBuilder out = new StringBuilder();

        String[] tokens = s.split(" ");
        for(int i = tokens.length - 1; i >= 0; i--){
            if(tokens[i] != ""){
                out.append(" " + tokens[i]);
            }
        }

        return out.toString().substring(1);
        
    }
}
