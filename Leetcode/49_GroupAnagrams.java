class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // maps sorted string to anagrams
        Map<String, List<String>> map = new HashMap();
        // go through every word
        for (String str: strs){
            char [] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (map.containsKey(sorted)){
                map.get(sorted).add(str);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                map.put(sorted, anagrams);
            }
        }
        // add everything in map to result
        for (String key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}