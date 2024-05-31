class Solution {
    public boolean isPalindrome(int x) {
        
        String s = String.valueOf(x);

        int size = s.length();

        for(int i = 0; i < size/2; i++){

            if(s.charAt(i) != s.charAt(size - 1 - i)){

                return false;
            }
        }
        return true;

    }
}
