/*
https://leetcode.com/problems/can-place-flowers/submissions/1285043066
Decent problem with what felt like a very obvious O(n) solution
My approach was to traverse the array once, finding all the locations of where the flowers are at and put a 2 next to them to represent that space as not occupied,
  but not usable either. Then traverse the array again, finding all of the left over spaces

...Or at least that was the original idea, until I realized I could modify the array AND figure out what spaces were left in just one pass, 
https://leetcode.com/problems/can-place-flowers/submissions/1285051526/
Although this solution doesn't show any speed improvements, it is definitely faster and I am happy with leaving it here
I like this problem a bit more now
*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        //since we have 1 to represent not empty and 0 to represent empty, I'm going to introduce 2 to represent an empty but not usable space
        int counter = 0;
        
        //handle edge cases
        //case if flowerbed is 1 long
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0){
                counter = 1;
            }
            if(n <= counter){
                return true;
            }
            return false;
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            counter++;

        }
        if(flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0){
            flowerbed[flowerbed.length-1] = 1;
            counter++;
        }
        for(int i = 1; i <= flowerbed.length-2; i++){
            
            if(flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                counter++;
                i++;
            }

        }

        if(n <= counter){
            return true;
        }
        return false;

    }
}
