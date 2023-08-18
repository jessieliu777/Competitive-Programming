class Solution {
    // map[word] = word break of word
    HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    Set<String> wordSet;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (wordSet == null) wordSet = new HashSet(wordDict);
        if(s == null || s.length() == 0) return res;
        
        if(map.containsKey(s)) return map.get(s);
        // if cur string is in word set then add it to result   
        if(wordSet.contains(s)) res.add(s);
        
        // for every substring s[i..]
        for(int i = 1 ; i < s.length() ; i++) {
            String substr = s.substring(i);
            // if wordset contains the substring
            if(wordSet.contains(substr)) {
                // find the word break of the str minus substr
                List<String> temp = wordBreak(s.substring(0, i) , wordDict);
                if(temp.size() != 0) {
                    // for every word break in the str minus substr, we can make a word break of str by adding that word break + substr
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + substr);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}