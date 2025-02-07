"""
https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/submissions/1534913098
Daily problem 2/7/25

Not too bad once I figured out what the question was asking
I was able to figure out the two hash approach by myself, but doubted myself when my submission ran out of time
When I'm stuck on a leetcode problem, one of my ideas to comb through my code is to go line by line and write it down
Of course thats where I see the fact that I submitted a solution that prints something every single loop
No wonder my time limit exceeded
So I fixed that, got a decent time, fixed up some confusing code, and things got marginally faster
Again, not that bad but I'm definitely starting to feel the increasing difficulty

"""

class Solution(object):
    def queryResults(self, limit, queries):
        """
        :type limit: int
        :type queries: List[List[int]]
        :rtype: List[int]
        """

        out = []
        color_map = {}
        balls = {}
        counter = 0

        for query in queries:
            loc = query[0]
            color = query[1]

            #if we are changing a ball's color
            if loc in balls:
                prev_color = balls[loc]
                color_map[prev_color].remove(loc)
                #if we remove the last distinct color for a given color, decrement the counter
                if len(color_map[prev_color]) == 0:
                    counter -= 1

            balls[loc] = color

            if color in color_map and len(color_map[color]) != 0:
                    color_map[color].append(loc)
            else:
                color_map[color] = [loc]
                counter += 1
                
            out.append(counter)
        return out


        
