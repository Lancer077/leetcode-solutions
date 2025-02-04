"""
https://leetcode.com/problems/create-a-dataframe-from-list/submissions/1531141207

Learning pandas because that's one of the data pipeline things we plan on using for the solar car telemetry system
I know the most python so I figured I'd take the pandas stuff
"""

import pandas as pd

def createDataframe(student_data: List[List[int]]) -> pd.DataFrame:
    return pd.DataFrame(student_data, columns = ["student_id", "age"])
