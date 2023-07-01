class Solution:
    def goodSubsetofBinaryMatrix(self, grid: List[List[int]]) -> List[int]:
#        Since each row in the #input is small ($n < 5$), we can encode them into a integer. We have at most $2^5$ integers to handle. We call them values.

#A valid subset of values can be a single {0} or a pair {a, b} where a & b == 0.

#In the sections below we will always consider subset of values rather than their indices. It is trivial to get the indices once we figured out the values.

#We prove that if any valid non empty subset exists then there must be a valid subset of one of the following types:

#A subset of a single value {0}.
#A subset of two values{a, b} where a & b == 0
#We prove it by contradiction:

#Assume there is a valid non empty subset $S$ and there is no valid subset of the two above cases.

#If $|S| = 1$, then the single element in it must be 0, which is the type 1 above. Therefore $|S| > 1$
#For two elements $a \in S$ and $b \in S$, if a & b == 0 then we have a subset {a, b} of type 2 above. Therefore any two elements in $S$ must share some bits.
#Now consider the average number of bits in all the values in $S$. They can be at most 2.5 since $n \le 5$ (n is the number of bits involved in this question) and each bit "column" has at most half set. This means that we have at least one value $x \in S$ that has at most 2 bits set.

#If $x$ has 0 bit set, that gives us type 1.
#If $x$ has 1 bit set, then all other values in $S$ must have that bit set as well, therefore that bit position will violate the "half length" condition.
#Now $x$ has exactly two bits set. WLOG let's say we get x = 0b00011.
#Since any other values in $S$ must share at least a bit with $x$, we have the total bit counts at bit position 0 and 1 to be at least $|S| + 1$ (each number has bit position 0 or 1 set and $x$ has both set). This means one of them will violate the "half the length" condition.
#Q.E.D.

#Note: As the proof goes, we can see that it is only valid for $n \le 5$. In fact for $n = 6$ we have a counter example:
#0 0 0 1 1 1
#1 1 0 1 0 0
#1 0 1 0 1 0
#0 1 1 0 0 1

#Complexity
#Time complexity:
# $\Theta(N)$ where $N$ is the number of rows.

# Technically it is actually $\Theta(N k + 2^{2k})$ where $k$ is the number of columns. We ignored that since our algorithm only works for $k \le 5$ anyway so we treated it as a constant.

# Space complexity:
# $\Theta(2^k)$ where $k$ is the number of columns.
        # 1. map(str, row) converts every row[i] to str(row[i])
        # 2. ''.join(_) converts _ (coverted row from 1) to str where each row[i] is concatenated
        # 3. int(_, 2) converts _ (converted str from 2) to base 2 int
        # 4. {_: i} maps every _ (converted base int) to index i
        rowbitsToIndex = {int(''.join(map(str, row)), 2): i for i, row in enumerate(grid)}
        # product(a, b) returns cartesian product of a, b
        for a, b in product(rowbitsToIndex, rowbitsToIndex):
            if not a & b:
                return sorted({rowbitsToIndex[a], rowbitsToIndex[b]})
        return []
        