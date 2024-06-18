/*
https://leetcode.com/problems/most-profit-assigning-work/description/
https://leetcode.com/problems/most-profit-assigning-work/submissions/1292880668/
I spent about 2 hours on this on and off and it was probably the most work I've ever put into a problem here. 
Yes I know the speed is terrible but I'm using insertion sort here instead of something like quicksort or mergesort so I figure that is probably the reason.
I'll eventually come back and learn and implement something like bottom up mergesort and throw that one into here but for right now, I'm happy with my solution.
*/

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        //El Plan:
        //sort workers in descending order of Skill
        //sort tasks in descending order of profitability
        //iterate through worker array
        //"And now we win" -Prof Li
        //it took an entire sheet of paper but by god do I have an idea

        //insertion sort on the workers array
        for(int i = 1; i < worker.length; i++){
            int key = worker[i];
            int j = i - 1;

            while(j >= 0 && worker[j] < key){
                worker[j + 1] = worker[j];
                j = j - 1;
            }
            worker[j + 1] = key;
        }

        //insertion sort on profit array (while also updating the difficulty array accordingly)
        for(int i = 1; i < profit.length; i++){
            int key = profit[i];
            int diffKey = difficulty[i];
            int j = i - 1;

            while(j >= 0 && profit[j] < key){
                profit[j + 1] = profit[j];
                difficulty[j + 1] = difficulty[j];
                j = j - 1;
            }
            profit[j + 1] = key;
            difficulty[j + 1] = diffKey;
        }
    
        //now that everything is sorted, we loop through the worker array

        int totalProfit = 0;
        int diffIndex = 0; //to store where we are at in terms of worker skill vs task difficulty
        int workerIndex = 0;

        while(workerIndex < worker.length && diffIndex < difficulty.length){
            while(worker[workerIndex] < difficulty[diffIndex]){ //while worker skill is less than task difficulty
                diffIndex++; //go to next task difficulty
                if(diffIndex == difficulty.length){ //prevent indexoutofbounds exceptions
                    break;
                }
            }
            //once worker skill is equal to or greater than skill difficulty
            if(diffIndex < difficulty.length){
                totalProfit += profit[diffIndex];
                workerIndex++;
            }
        }
        return totalProfit;
    }
}
