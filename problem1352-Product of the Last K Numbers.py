"""
https://leetcode.com/problems/product-of-the-last-k-numbers/submissions/1543101245
Daily Problem 2/14/25

Today was interesting
I had the correct approach with using a prefix list, but I could not understand how to use that to get the products, so I thought maybe my approach was wrong and spent quite a bit of time trying to change that
as it turns out, I did have the correct approach, I just didn't realize you needed to divide the last and the k values to get the answer
Looking back on it now, I feel a little silly for not discovering that approach by myself, but I'm also kinda happy with myself for having the intuition to figure out the correct approach to begin with

"""

class ProductOfNumbers(object):

    def __init__(self):
        #self.stream = [] #stored the stream for debugging
        self.prefixes = [1]
        

    def add(self, num):
        """
        :type num: int
        :rtype: None
        """
        #self.stream.append(num)
        self.prefixes.append(num * self.prefixes[-1])

        if num == 0:
            self.prefixes = [1]


    def getProduct(self, k):
        """
        :type k: int
        :rtype: int
        """
        if k >= len(self.prefixes):
            return 0
        return self.prefixes[-1] // self.prefixes[-k-1] #this is the part that tripped me up
        
        


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)
