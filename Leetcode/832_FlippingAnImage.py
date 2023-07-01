class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        # if i == 1 then 1^i = 0, if i == 0 then 1^i = 1, so 1^i inverts i as wanted
        return [[1 ^ i for i in reversed(row)] for row in image]