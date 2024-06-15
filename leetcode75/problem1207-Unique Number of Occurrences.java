/*
https://leetcode.com/problems/unique-number-of-occurrences/description/
https://leetcode.com/problems/unique-number-of-occurrences/submissions/1289320480/
Simple problem, I could have tried to optimize for space but I don't exactly have a passion for that 
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //took one look at the problem and it's an easy counting sort problem
        int size = 2001; //add the extra 1 for zero
        int offset = -1000;

        int[] counter = new int[size];
        int helper = 0;

        for(int i = 0; i < arr.length; i++){
            helper = arr[i];
            counter[helper-offset]++;
        }

        HashSet<Integer> unique = new HashSet<Integer>(); //access in O(1)
        for(int i = 0; i < counter.length; i++){
            if(counter[i] != 0){
                if(unique.contains(counter[i])){ //if we already have an element with that number of occurences
                    return false; //answer is false
                }
                unique.add(counter[i]); //if not, we add that occurence number to the hashset
            }
        }
        return true; //if we make it to the end of the array and have not found a duplicate, the answer is true
    }
}
