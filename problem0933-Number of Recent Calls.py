"""
https://leetcode.com/problems/number-of-recent-calls/submissions/1556247868

Not too bad, pretty fun little problem
"""

class RecentCounter(object):

    def __init__(self):
        self.requests = []

    def ping(self, t):
        """
        :type t: int
        :rtype: int
        """
        
        
        while len(self.requests) > 0 and self.requests[0] < (t - 3000):
            self.requests.pop(0)

        self.requests.append(t)

        return len(self.requests)
        


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
