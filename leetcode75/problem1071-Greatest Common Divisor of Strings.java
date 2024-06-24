/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
https://leetcode.com/problems/greatest-common-divisor-of-strings/submissions/1298915424/
Trivial if you know what you are doing.
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        //start at the largest and go down to prevent always going through the entire string looking for a divisor
        //check if a divisor could exist to begin with
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int str1Len = str1.length();
        int str2Len = str2.length();
        for(int i = str1Len; i > 0; i--){
            if(str1Len % i == 0 && str2Len % i == 0){
                return str2.substring(0, i);
            }
        }
        return "";
    }
}
