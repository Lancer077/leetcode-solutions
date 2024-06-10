/*
Problem of the day 6.10.24
Easy problem, I was expecting to be forced to find a O(n) solution but O(n^2) would do just fine
I could have implemented a faster sort than insertion sort but it did not seem like it was worth it for such a simple problem
https://leetcode.com/problems/height-checker/description/
*/

class Solution {
    public int heightChecker(int[] heights) {

        //copy the array over

        int[] arr = new int[heights.length];

        for(int i = 0; i < heights.length; i++){
            arr[i] = heights[i];
        }
        
        //I should find my old mergesort code and put it on my github so I can always just copy/paste my own code and have a fast sort

        //I'm just going to use insertion sort here bc it's not that deep and really is just a standard problem

        int j;
        for(int i = 1; i < arr.length; i++){
            j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int t = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = t;
                j--;
            }
        }


        //check where the two arrays do not match
        int counter = 0;
        for(int i = 0; i < heights.length; i++){
            if(arr[i] != heights[i]){
                counter++;
            }

        }

        return counter;

    }
}
