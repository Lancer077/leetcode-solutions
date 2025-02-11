"""
https://leetcode.com/problems/remove-all-occurrences-of-a-substring/submissions/1539726108
Daily problem 2/11/25

Not too bad, as I've said before, I'm definitely feeling the heat in terms of question difficulty but this one wasn't too bad
I'm fully aware that I didn't need to turn the stack into a string each time I wanted to check if the pattern matches, but I like to keep easy to read/write code practices so I ended up with this
Definitely room for optimization though
"""


class Solution(object):
    def removeOccurrences(self, s, part):
        """
        :type s: str
        :type part: str
        :rtype: str
        """

        """
        Looks similar to yesterday which was a stack problem
        Kinda cool how it feels like they used yesterday to build up to today
        It almost feels like the valid parenthesis problem    
        """

        part_len = len(part)

        if part_len == 1:
            return s.replace(part, "")

        #doing outright string manipulation is slow
        #looping through the back end of the stack sounds boring
        #Time complexity might ream me here but we'll see I guess
        def stack_to_str(stack):
            updated = ""
            for char in stack:
                updated += str(char)
            return updated

        stack = []

        for char in s:
            stack.append(char)
            stack_str = stack_to_str(stack)
            if stack_str.endswith(part):
                for i in range(part_len):
                    stack.pop()


        return stack_to_str(stack)
            

        
