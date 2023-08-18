class Solution:
    def sortEvenOdd(self, nums: List[int]) -> List[int]:
        # nums[::2] gets all the numbers from beginning by 2 steps
        # nums{1::2} gets all the numbers from index 1 by 2 steps
        # sorted gives increasing order, so do [::-1] to reverse
        nums[::2], nums[1::2] = sorted(nums[::2]), sorted(nums[1::2])[::-1]
        return nums