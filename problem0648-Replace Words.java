/*
Daily problem 6/7/2024
https://leetcode.com/problems/replace-words/description/
Originally thought it was asking to handle cases where the root word was not at the beginning of the string, but after figuring that out, I was a lot more pleased with the overall code efficiency
There are definitely ways I can think of to improve the code efficiency, such as sorting the dictionary for larger sentences, less string manipulation (java does not modify strings, just makes
      a copy and modifies that throws that modified string back into the original variable (this is slow))
Overall decent problem and it felt more trivial than some of leetcode's "easy" problems

*/

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        String[] words = sentence.split(" "); //break up the sentence string into string array of words to make it easier to work with each word
        String rootSentence = "";

        //1 if there exists a substring inside a word such that the substring is found in the dictionary list, replace the word with that substring
        //2 if there exists more than one substring that fits, replace with the shorter substring

        //O(n) for looping through the words
        //O(n^2) for looping through the dictionary
        //O(n) may be possible but I cannot be sure
        
        boolean match;
        String root;
        for(int i = 0; i < words.length; i++){
            root = words[i]; //in case we do not find a root word, we still have the original
            //also doubles as a way to have a base case for finding the root word which is (in Borat voice) VERY NAICE 

            for(int j = 0; j < dictionary.size(); j++){

                match = words[i].startsWith(dictionary.get(j));

                if(match && dictionary.get(j).length() < root.length()){ //if is a match and shorter than our current root
                    root = dictionary.get(j); //replace the root
                }


            }

            rootSentence = rootSentence + root + " ";

        }

        return rootSentence.substring(0, rootSentence.length()-1); //trim off the extra space at the end






    }
}
