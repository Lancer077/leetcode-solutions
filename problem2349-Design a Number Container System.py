"""
https://leetcode.com/problems/design-a-number-container-system/submissions/1535943143
Daily problem 2/8/25

I'll be honest, this was one of the more difficult mediums I've had to do in a while
I started with a similar approach as yesterday, using two dictionaries for fast lookup, and everything looked good until I got a time limit exceeded on my submission
I genuinely could not figure out the answer on my own so I went to the discussion part looking for a hint and that's when I found the SortedSet library
I was thinking about something along those lines but didn't know there was an actual library for it, so it was nice that I didn't have to implement my own
Overall, I think this problem was hard but not as hard as the submission rate would suggest, and now I have yet another tool in my kit moving forward

"""

class NumberContainers(object):

    def __init__(self):
        self.index_system = {}
        self.number_system = {}
    
    def insert(self, index, number):
        if number not in self.number_system:
            self.number_system[number] = SortedSet([index])
        else:
            self.number_system[number].add(index)
        

    def change(self, index, number):
        """
        :type index: int
        :type number: int
        :rtype: None
        """
        if index in self.index_system:
            prev_num = self.index_system[index]
            self.number_system[prev_num].remove(index)
        self.index_system[index] = number
        self.insert(index, number)


    def find(self, number):
        """
        :type number: int
        :rtype: int
        """
        if number in self.number_system and len(self.number_system[number]) > 0:
            return self.number_system[number][0]
        return -1
        


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)
