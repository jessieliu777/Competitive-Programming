class Solution:
    def countKSubsequencesWithMaxBeauty(self, s: str, k: int) -> int:
        # since want k subseq with max beauty, pick the values with top k freq
        freq = Counter(s)
        # if there's not enough unique chars to make k-subseq, then we are done
        if len(freq) < k: 
            return 0
        # otherwise get the top k freq value, since we wanna maximize beauty
        topk = nlargest(k, freq.values())
        # get the kth freq value
        bar = min(topk)
        # Then we iterate all frequencies,
        # If freq > bar, will be selected, res = res * freq % mod
        # If freq == bar, will become a pending candidates, and we only need some of them.
        # Finally we return product(k biggest frequencies) * combination(pending, need), where pending is the freq == k in s, pending is the number freq == k in top k freq. Take the product of everything in k biggest freq since every index is considered unique even if the char is the same. So for ex for given unique chars a, b, c, is in the topk freq, the number of choices is ways to pick a * ways to pick b * ways to pick c * pending choose need = freq(a) * freq(b) * freq(c) * pending choose need
        # reduce (mul, topk) = product of all the freqs on topk
        # comb(tuple(freq.values()).count(bar), topk.count(bar)) = number of freq with exactly freq = k choose number of top k freq with exactly freq = k
        return reduce(mul, topk) * comb(tuple(freq.values()).count(bar), topk.count(bar)) % (10 ** 9 + 7)