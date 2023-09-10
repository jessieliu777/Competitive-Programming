class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        # The zip() function returns a zip object, which is an iterator of tuples where the first item in each passed iterator is paired together, and then the second item in each passed iterator are paired together, ... etc
        # *matrix unpack the original input list M into multiple sublists(rows)
        # so zip(*matrix) essentially transpose the matrix

        # * is the "splat" operator: It takes an iterable like a list as input, and expands it into actual positional arguments in the function call.
        # So if uniqueCrossTabs were [[1, 2], [3, 4]], then itertools.chain(*uniqueCrossTabs) is the same as saying itertools.chain([1, 2], [3, 4]), not same as itertools.chain(uniqueCrossTabs) = itertools.chain([[1, 2], [3, 4]])
        # in this case if matrix = [[1, 2], [3, 4]], zip(matrix) = zip([1, 2], [3, 4])
        # zip pairs items together by index so the result is [[1, 3], [2, 4]] which is matrix.T as wanted
        return zip(*matrix)