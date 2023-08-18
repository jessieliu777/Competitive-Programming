class Solution:
    def splitWordsBySeparator(self, words: List[str], separator: str) -> List[str]:
        # for word in words: for w in word.split...
        return [w for word in words for w in word.split(separator) if w]