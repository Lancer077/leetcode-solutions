/*
I kept getting leetcode problems with sorting and instead of trying to recode sorting algorithms from scratch,
  I figured it would be easier to just make my own sorting implementations and copy/paste from there each time.
So we are starting with insertion sort because it's the fastest of the elementary sorts
*/

class InsertionSort {
    void sort(int array[])
    {
        int size = array.length;
        for(int i = 1; i < size; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
