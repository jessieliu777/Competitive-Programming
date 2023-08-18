class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        result = 1
        for digit in b:
            # res = prev res ^ 10 * a ^ digit 
            # = (a ^ prev digit) ^10 * a ^ digit
            # = a ^ (prev digit * 10 ) * a ^ digit
            # = a ^ (prev digit * 10 + digit)
            result = pow(result, 10, 1337) * pow(a, digit, 1337) % 1337
        return result