"""
https://leetcode.com/problems/get-the-size-of-a-dataframe/submissions/1531146332

all that jupyter notebook experience is coming in handy
"""
import pandas as pd

def getDataframeSize(players: pd.DataFrame) -> List[int]:
    return list(players.shape)
