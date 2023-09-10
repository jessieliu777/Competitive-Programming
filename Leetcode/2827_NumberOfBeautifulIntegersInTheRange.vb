class Solution:
    def numberOfBeautifulIntegers(self, low: int, high: int, k: int) -> int:
        '''
        @param string the stringified num
        @param index the index of the cur digit
        @param odd_count the number of odd digits so far
        @param even_count the number of even digits so far
        @param remainder of num[:index] after divided by k
        @param at_bound whether we are tight to maximal bound (to avoid counting nums > high). For ex cur digit = 5, when iterating digits i = 0 through 5, at i = 5 that's at bound. Since for digits < bound, the other iterations after cur index can take up any digit. For ex num = 53, if at i = 4, the next digit index = 1, can take any values from 0 to 9 ex 40 to 49, but at i = 5, the next digit can only be the up to 3, the index 1 value of 53.
        @param is_leading whether the cur digit is the leading digit (has the potential to be a leading 0)
        '''
        @cache
        def dfs(string, index, odd_count, even_count, remainder, at_bound, is_leading):
            # if we finished going through every digit, check if the num is beautiful
            if index >= len(string):
                return remainder % k == 0 and odd_count == even_count
            
            bound = int(string[index]) if at_bound else 9
            ans = 0
            # go through every digit from 0 to bound
            for digit in range(bound + 1):
                # flag if digit is odd or even
                is_odd = digit % 2 == 1
                is_even = digit % 2 == 0
                
                # if cur digit is a leading 0, don't count it as even
                if is_leading and digit == 0:
                    is_even = 0
                    
                ans += dfs(string, index + 1,
                           odd_count + is_odd,
                           even_count + is_even,
                           (remainder*10 + digit) % k,
                           at_bound and digit == int(string[index]),
                           is_leading and digit == 0)
            return ans
        # dfs(n) gets us the number of beautiful numbers in the range [0, n]
        # so what we want is dfs(high) - dfs(low - 1)
        return dfs(str(high), 0, 0, 0, 0, True, True) - dfs(str(low - 1), 0, 0, 0, 0, True, True)