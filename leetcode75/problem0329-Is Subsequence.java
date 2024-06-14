/*
https://leetcode.com/problems/is-subsequence/description
https://leetcode.com/problems/is-subsequence/submissions/1288284442
Not much to say about this one other than that it is another prime example of leetcode fishing for artificially lower submission acceptance rates.
Tied with or beat 92% of other submissions for speed efficiency.
*/

class Solution {
    public boolean isSubsequence(String s, String t) {

        int sIndex = 0;

        if(s.equals("")){
            return true;
        }

        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(sIndex)){
                sIndex++;
                if(sIndex == s.length()){
                    return true;
                }
            }
        }

        return false;
        
    }
}
