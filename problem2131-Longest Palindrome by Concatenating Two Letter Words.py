"""
https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/submissions/1644156528

Daily Problem 5.25.25
Not the cleanest solution and certainly not the fastest compared to some other submissions but I still think it's kinda good
Oddly enough I used a similar approach to a differences array, isn't that funky?
"""
class Solution:
    def longestPalindrome(self, words: List[str]) -> int:

        palindrome_length = 0
        word_map = {}
        doubles = set()     #you're just gonna have to trust me on this one

        for word in words:
            if word[0] == word[1]:  #storing double letters separately because if we have two instances of the same double letter
                if word in doubles: #then we can just treat it like normal, but for example if we have "aa" and "bb" then only
                    doubles.remove(word) #one of those can be in the middle and I use a set to prevent needing to loop through
                    palindrome_length += 4 #the hashmap at the end because that would be very slow
                else:
                    doubles.add(word)
            elif (word[1] + word[0]) in word_map and word_map[word[1] + word[0]] > 0:
                word_map[word[1] + word[0]] -= 1
                palindrome_length += 4
            else:
                if word in word_map:
                    word_map[word] += 1
                else:
                    word_map[word] = 1
        if len(doubles) > 0:
            palindrome_length += 2
        return palindrome_length
