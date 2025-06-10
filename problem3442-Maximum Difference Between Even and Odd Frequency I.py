"""
https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/submissions/1659785403


Daily Problem 6.10.25
Saw it was an easy problem so I was excited, ended up not reading the description well enough and failed my first submission
100% on the time efficiency so that's cool, overall a faily easy hashmap problem
"""
class Solution:
    def maxDifference(self, s: str) -> int:
        frequency_map = {}

        for char in s:
            if char in frequency_map:
                frequency_map[char] += 1
            else:
                frequency_map[char] = 1
        
        min_even = 100 #s.length can at max be 100 characters but also must have space for at least one character with an odd number of appearances
        max_odd = 0

        for key in frequency_map:
            value = frequency_map[key]
            if value % 2 == 0 and value < min_even:
                min_even = value
            elif value % 2 == 1 and value > max_odd:
                max_odd = value
        
        return max_odd - min_even
