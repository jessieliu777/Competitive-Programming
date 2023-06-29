class Solution:
    def minimizeConcatenatedLength(self, words: List[str]) -> int:
        cache = {}
        # i = cur index, first = first letter of pre word, last = last letter of pre word
        def helper(i,first,last):
            # skip out of bounds
            if i==len(words): 
                return 0
            # if cur state wasn't already calculated before
            if (i,first,last) not in cache: 
                # try to add the cur word right. new word starts with pre first letter, and ends with cur's last letter. remove the repeated letter of the joined cur and pre if exists.
                putLast = helper(i+1,first,words[i][-1]) - int(words[i][0]==last)
                # try to add the cur word left. new word starts with cur word's first letter, and ends with the same as pre. remove the repeated letter of the joined cur and pre if exists.
                putFirst = helper(i+1,words[i][0],last) - int(words[i][-1]==first)
                # store the len of the joint cur word + nxt word
                cache[(i,first,last)] = len(words[i]) + min(putFirst,putLast)
            return cache[(i,first,last)]
        return len(words[0]) + helper(1, words[0][0] , words[0][-1])