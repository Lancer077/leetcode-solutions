"""
https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/submissions/1508681930

did this in class
"""

class Solution(object):
    def findThePrefixCommonArray(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        set_a = []
        set_b = []
        return_list = []
        cur_counter = 0

        #assuming that each element in A and B are unique within each set
        for i in range(len(A)):
            if A[i] == B[i]:
                cur_counter += 1
            else:
                if A[i] in set_b:
                    cur_counter += 1
                else:
                    set_a.append(A[i])
                if B[i] in set_a:
                    cur_counter += 1
                else:
                    set_b.append(B[i])
            return_list.append(cur_counter)
        
        return return_list
            
        
