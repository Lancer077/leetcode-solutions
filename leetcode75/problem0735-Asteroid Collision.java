/*
https://leetcode.com/problems/asteroid-collision/description
https://leetcode.com/problems/asteroid-collision/submissions/1291765824

Asteroid Collision is better known as edge case hell as there are so many ways for the inputs to trip you up.
But the one thing I really love about coding is that almost always, the elegant solution will be better than manually handling all of the edge cases individually.
I unfortunately did not do this but still came out with a fairly impressive result beating 82% of other results and tying only 9% of other submissions.
I am very pleased with myself as this is the type of problem I would have previously skipped for it's difficulty and tedium, but sticking with it I gained a new tool of learning how to use
  a list as a stack and queue at the same time. Stack was for collision, queue was for the result.
Who would have thought the Leetcode 75 study plan, designed for helping people learn to code better, would have done exactly that?
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        //list approach
        List<Integer> survivors = new ArrayList<Integer>();

        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0) { survivors.add(asteroids[i]);} //if positive, we just add to the list

            else if(asteroids[i] < 0 && survivors.isEmpty() || survivors.get(survivors.size()-1) < 0){ //if negative
                survivors.add(asteroids[i]); //and if list is empty or only contains negative numbers, we just add to the list
            }

            else if(asteroids[i] < 0 && survivors.get(survivors.size()-1) > 0){ //if negative and if list contains positive numbers
                int top = survivors.get(survivors.size()-1); //get the last/first/most recently inserted/rightmost/etc... element in the array
                while(top > 0 && top < (asteroids[i] * -1) && survivors.size() > 0){
                    survivors.remove(survivors.size()-1); //remove the smaller number
                    if(survivors.size() == 0){break;} //if the list is now empty, we break to prevent an index out of bounds, also because we should just add asteroids[i] to the list now
                    top = survivors.get(survivors.size()-1);
                }
                if(top == Math.abs(asteroids[i])){ //edge case
                    survivors.remove(survivors.size()-1);
                }
                else if(top < 0 || survivors.isEmpty()){ //else if edge case
                    survivors.add(asteroids[i]);
                }

            }
        }

        int[] leftOver = new int[survivors.size()];

        for(int i = 0; i < survivors.size(); i++){ //turn the list into an integer array
            leftOver[i] = survivors.get(i);
        }

        return leftOver;
        
    }
}
