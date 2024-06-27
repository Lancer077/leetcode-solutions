/*
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1302277325/ - 11ms, 86%
After a small optimization,
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1302280819/ - 10ms, 92%
What changed? only checking the Math.max if we incremented, because there is no reason to check if we didn't increment because if we didn't increment then
even if we didn't decrement we still can guarantee there is no new max.

I had worked on this problem previously and was just stuck, until I came back today and got it first try after spending too much time on the 
  3 increasing numbers subsequence problem. 
Pretty decent runtime and space on my solution too.
I don't know what my old problem was but I'm just glad to be done with this one.
*/

class Solution {
    public int maxVowels(String s, int k) {
        int vowelCounter = 0; //start the sliding window

        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                vowelCounter++;
            }
        }

        int maxVowels = vowelCounter; //base case

        //recursive case
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i-k))){ //if we are leaving a vowel behind
                vowelCounter--; //decrement
            }
            if(isVowel(s.charAt(i))){ //if we are gaining a new vowel
                vowelCounter++; //increment
                maxVowels = Math.max(maxVowels, vowelCounter); //check if we have a new max
            }
        }
        return maxVowels;
    }

    //helper isVowelFunction, checks if a passed in character is a vowel
    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}
