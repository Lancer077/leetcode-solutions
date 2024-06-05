/*
More work than I would have expected from an "easy" problem and unfortunately my solution ended up being O(n^3) time complexity
*/
class Solution {
    public List<String> commonChars(String[] words) {

        List<String> duplicates = new ArrayList<String>(); //create a string list for returns
        
        int numOfWords = words.length;

        //first word: put each individual letter into the duplicates
        //every word after: if the letters are found, do the stuff
        String firstWord = words[0];

        
        for(int i = 0; i < firstWord.length(); i++){ //put the letters into the string list
            duplicates.add(firstWord.substring(i, i+1));
        }
        //current time complexity: O(n) where n is the length of the first word

        String curWord;
        int index;
        for(int i = 1; i < words.length; i++){ //iterate over each word, start at index 1 because we already had the first word
            curWord = words[i];
            List<String> temp = new ArrayList<String>(); //to hold stuff for me


            for(int j = 0; j < duplicates.size(); j++){ //iterate over each letter in duplicates
                index = curWord.indexOf(duplicates.get(j)); //O(n^3) :O

                if(index != -1){ //if we found the letter
                    temp.add(duplicates.get(j)); //add it to our temporary storage
                    curWord = curWord.substring(0, index) + curWord.substring(index+1);
                }

            }

            duplicates = temp;

        
        }

        


        return duplicates;


    }
}
