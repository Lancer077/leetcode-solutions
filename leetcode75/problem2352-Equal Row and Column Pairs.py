"""
https://leetcode.com/problems/equal-row-and-column-pairs/submissions/1554153388

Fun problem, I'm happy that I didn't need to use any hints or the discussion to be pointed in the right direction
Just a hashmap approach did pretty well to provide O(n) solution, but this approach did kind of kill my space efficiency
"""

class Solution(object):
    def equalPairs(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row_list = []
        col_list = []
        for row in range(len(grid)):
            row_list.append(grid[row])
            for column in range(len(grid[row])):
                if row == 0:
                    col_list.append([grid[row][column]])
                else:
                    col_list[column].append(grid[row][column])

        def list_to_map(input_list):
            entry_map = {}
            for entry in input_list:
                entry_tup = tuple(entry)
                if entry_tup not in entry_map:
                    entry_map[entry_tup] = 0
                entry_map[entry_tup] += 1
            return entry_map
        
        row_map = list_to_map(row_list)
        col_map = list_to_map(col_list)
        counter = 0

        for row in row_map:
            if row in col_map:
               counter += row_map[row] * col_map[row] 
        
        return counter
