/*
https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/1285084949/
I can't exactly say I enjoyed doing this problem, I know my solution could be considered sloppy at best, but I am just apathetic about it because I do not see
  a faster solutions that also results in 'good' code
The char array approach made it slightly easier to code and from now on when doing string substitution I think it will become my goto
Unimpressive runtime but I'm not surprised
Might come back to this one
probably wont
*/
class Solution {
    public String reverseVowels(String s) {
        List<Integer> indicies = new ArrayList<Integer>();
        List<Character> foundVowels = new ArrayList<Character>();
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        char[] chars = s.toCharArray();

        char c;
        
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i); //don't need to use another variable, just helps with readability
            if(vowels.contains(c)){ 
                indicies.add(i);
                foundVowels.add(s.charAt(i));
            }
        }

        int index;
        for(int i = 0; i < indicies.size(); i++){
            index = indicies.get(i);
            chars[index] = foundVowels.get(foundVowels.size()-i-1);
        }

        return String.valueOf(chars);

            
    }
}
