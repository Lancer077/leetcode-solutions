"""
https://leetcode.com/problems/dota2-senate/submissions/1643355886

A problem that has barely anything to actually do with Dota but still a cool problem nonetheless
I was intimidated by this problem for a while so being able to come here and do it now with relative ease was pretty cool
I definitely could have a cleaner and faster solution, but I'm still fairly proud of how I solved this one

"""
class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        #loop through the senate string,
        #each time we come across a senator, we remove the next instance of the opposing party
        #stop when there is only one party left

        def senator_action(senate: str, senator: str, index: int):
            parties = ["R", "D"] #thought this approach was kinda smart, generalizes the program flow for each party
            parties.remove(senator)

            if parties[0] in senate[index:]:
                loc = senate.find(parties[0], index)
            elif parties[0] in senate: 
                loc = senate.find(parties[0])
                index -= 1 #if we are removing an element behind the current index, removing that element will increment our position
            else:           #naturally so therefore we do not want to increment
                return senate, index
            return (senate[:loc] + senate[loc + 1:]), index       

        index = -1
        while len(set(senate)) == 2:
            index += 1
            if index >= len(senate):
                index = 0
            senate, index = senator_action(senate, senate[index], index)
        
        if senate[0] == "R":
            return "Radiant"
        return "Dire"
            
