"""
https://leetcode.com/problems/string-to-integer-atoi/submissions/1649061869

This problem humbled me in a new way: annoyance
I was definitely very annoyed at how many edge caes I needed to take care of, but at the same time, the problem does state everything you need to know in order to get the answer in one try
I certainly could have created more of my own test cases, and I think the reason I found this problem annoying is because it goes against how I typically work
I am more of a "move fast break things" kind of person when coding, and that is a big part of why I mainly program in python, it allows me to move fast
This problem prefers a slow and steady approach, which although I find annoying now, I know I will need it in my back pocket for the future, especially for employers
"""

class Solution:
    def myAtoi(self, s: str) -> int:
        
        output = 0
        negative_multiplier = 1
        encountered_leading_zeros = False #this will be a useful flag to know when to stop reading in the string
        whitespace_flag = False #this will be true when we encounter anything that isn't whitespace
        encountered_sign = False

        upper_bound = (2**31) - 1
        lower_bound = -(2**31)


        for char in s:
            if char == " ":
                if whitespace_flag:
                    break
                else:
                    continue
            elif char == "-":
                if encountered_sign or encountered_leading_zeros or output != 0:
                    break
                else:
                    negative_multiplier = -1
                    encountered_sign = True
                    whitespace_flag = True
            elif char == "0":
                if output == 0:
                    encountered_leading_zeros = True
                    whitespace_flag = True
                else:
                    output *= 10
            elif char.isdigit():
                whitespace_flag = True
                output *= 10
                output += int(char)
            elif char == "+":
                if whitespace_flag:
                    break
                encountered_sign = True
                whitespace_flag = True
            else:
                break
            
        
        output = output * negative_multiplier
        print(output)
        if output > upper_bound:
            return upper_bound
        if output < lower_bound:
            return lower_bound
        return output



            
            
                        

