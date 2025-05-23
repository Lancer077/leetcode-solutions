"""
https://leetcode.com/problems/string-compression/submissions/1642328426

Definitely not my cleanest code but it wasn't too bad to be honest although I do have beef with whoever at LeetCode decided they would check for array modification through seeing what elements we update because whoever implemented it did it stupidly
Instead of just checking the array itself like someone with basic intelligence would do, array modification is checked by seeing if the element after it was accessed (this is stupid)
"""
class Solution:
    def compress(self, chars: List[str]) -> int:
        #hey I think I did a similar problem during advent of code 2024!
        #take care of base case
        if len(chars) == 1 or len(chars) == 0:
            return len(chars)

        #variable setup
        char_counter = 1
        cur_index = 0        #this one will help us modify the original array
        last_char = chars[0]

        for index in range(1, len(chars)):
            if last_char == chars[index]: #if same character as last time, just increment the counter
                char_counter += 1

            else:
                chars[cur_index] = last_char #if not same character as last time, throw the old characters into the array
                last_char = chars[index]
                cur_index += 1

                if char_counter > 1:
                    ctr = str(char_counter)
                    for c in ctr:
                        chars[cur_index] = c
                        cur_index += 1
                    char_counter = 1

        chars[cur_index] = last_char
        cur_index += 1
        #physically painful to copy code but passing everything through methods would be even more annoying
        if char_counter > 1:
            ctr = str(char_counter)
            for c in ctr:
                chars[cur_index] = c
                cur_index += 1
        cur_index += 1 #this line is stupid because the way leetcode wants to check for constant extra space is stupid
                        #for a space in the original array to count as "modified", you have to update the space after it
                        #this is a stupid way of doing things when they could just check the actual gobstopping array itself

        return cur_index-1
        
