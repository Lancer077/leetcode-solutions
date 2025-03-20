"""
https://leetcode.com/problems/display-the-first-three-rows/submissions/1580735610
same as return employees.head(3)
"""
import pandas as pd
def selectFirstRows(employees: pd.DataFrame) -> pd.DataFrame:
    return employees[:3]
