"""
https://leetcode.com/problems/strong-password-checker-ii/submissions/1637457090

the continue keyword stays winning
"""

class Solution:
    def strongPasswordCheckerII(self, password: str) -> bool:
        if len(password) < 8:
            return False
        
        lower =   False
        upper =   False
        digit =   False
        special = False
        special_characters = "!@#$%^&*()-+"
        last_char = None

        #a regex based approach might be faster than this solution
        for char in password:
            if char == last_char: #if two characters adjacent, we already know password is not strong
                print(last_char)
                return False
            last_char = char
            if char.isdigit():
                digit = True
                continue #using the continue to improve performance, if the character is a digit, then it probably isn't a letter
            if char in special_characters:
                special = True
                continue
            if char == char.lower():
                lower = True
                continue
            #if nothing else was true, then due to the constraints, we can assume upper
            upper = True
        return (digit and special and lower and upper)




            
            
            
            


        



