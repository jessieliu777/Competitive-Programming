class Solution:
    # We separate all the elements into two lists, depending on whether they are less than or more than the root. Then we recurse on those left and right sublists. The combination is for the macro ordering between left and right, and the recursive factors are for the internal ordering of left and right themselves. I minus 1 from the result because we don't count the original ordering.
    def numOfWays(self, nums: List[int]) -> int:
        def f(nums):
            if len(nums) <= 2: return 1
            left = [v for v in nums if v < nums[0]]
            right = [v for v in nums if v > nums[0]]
            # get the (combination of left len + right len choose right len) * num of ways to sort left * number of ways to sort right
            
            # explain where does comb(len(left)+len(right), len(right)) comes from
            # Comb(n, k) = # of ways to pick k elements out of n elements. In this case, it finds the number of ways to interleave nodes in the two subtrees.
            # For example, example 4 has two elements in the left subtree and 3 elements in the right subtree. Let's call them LL and RRR, Comb(5, 2) = pick 2 spots out of the 5 possible spots to put 2 Ls. We don't differentiate the two Ls because internal permutations are handled by the *f(left)*f(right). Note that Comb(5, 2) = Comb(5, 3) so it doesn't matter if we use len(left) or len(right) in the second argument.
            return comb(len(left)+len(right), len(right)) * f(left) * f(right)
        return (f(nums)-1) % (10**9+7)