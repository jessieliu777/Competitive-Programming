class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // create a dictionary of magazine from char: count
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++){
            map.merge(magazine.charAt(i), 1,  Integer::sum);
        }
        // if everything in magazine is in ransome note
        for (int j = 0; j < ransomNote.length(); j++){
            if (!map.containsKey(ransomNote.charAt(j))){
                return false;
            } else {
                int count = map.get(ransomNote.charAt(j));
                if (count <= 0){
                    return false;
                } else {
                    map.put(ransomNote.charAt(j), count-1);
                }
            }
        }
        return true;
    }
}