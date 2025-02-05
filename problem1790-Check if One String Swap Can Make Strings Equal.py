"""
https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/submissions/1531631450
Daily problem 2/5/25

Was hoping for something that took more than 10 minutes since I'm stuck in my boring python class today, unfortunately this took six and it's still 10 incredibly slow minutes until they releaes the lab
please just release the lab early so I can go back to grab dinner or do whatever

oh right I had the leetcode problem
so I figured my approach would be horribly inefficient (as per usual) but no, this one was actually pretty good
the sorted approach I figured would be slow but I also thought it was funny that it even worked, even more funny that it worked well
but pretty simple problem today
"""
class Solution(object):
    def areAlmostEqual(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        #get some obvious cases out of the way
        if s1 == s2:
            return True
        if len(s1) != len(s2):
            return False
        #python is a funny language for letting this work
        if sorted(s1) != sorted(s2):
            return False

        counter = 0
        for index in range(len(s1)):
            if s1[index] != s2[index]:
                counter += 1
                
        if counter == 2:
            return True
        return False
        
