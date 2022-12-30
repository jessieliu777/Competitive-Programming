class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(String s : words1) map.merge(s, 1, Integer::sum);//count frequency of words in words1
        //if s has frequency 1 in map or it isn't present in map
        for(String s : words2) if(map.getOrDefault(s, 0) < 2) map.merge(s, -1, Integer::sum);//decrement the frequency
        for(int e : map.values()) if(e == 0) res++;
        return res;
    }
}