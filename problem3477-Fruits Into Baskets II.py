"""
https://leetcode.com/problems/fruits-into-baskets-ii/description
https://leetcode.com/problems/fruits-into-baskets-ii/submissions/1724351480

Daily Problem 8.5.2025

Jumping back into things

"""

class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        unplaced = 0
        for i in range(len(fruits)):
            cur_fruit = fruits[i]
            for j in range(len(baskets)):
                if cur_fruit <= baskets[j]:
                    baskets.pop(j)
                    break
                elif j == len(baskets)-1:
                    unplaced += 1

        return unplaced
