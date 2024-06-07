/*
I remember doing this problem back in IT179 (introduction to data structures and algorithms) so I already knew that using a stack would be a good approach
Not much to say about this one, not too deep
https://leetcode.com/problems/valid-parentheses/description/
*/

class Solution {
    public boolean isValid(String s) {

        Stack<Character> input = new Stack<Character>();


        for(int i = 0; i < s.length(); i++){ //iterate through the string
            
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){

                input.push(s.charAt(i));

            }

            else if(input.isEmpty()){
                return false;
            }

            else if(s.charAt(i) == ')'){
                if(input.pop() != '('){
                    return false;
                }
            }

            else if(s.charAt(i) == ']'){
                if(input.pop() != '['){
                    return false;
                }
            }
            
            else if(s.charAt(i) == '}'){
                if(input.pop() != '{'){
                    return false;
                }
            }
        }

        if(!input.isEmpty()){
            return false;
        }
        
        return true;

    }
}
