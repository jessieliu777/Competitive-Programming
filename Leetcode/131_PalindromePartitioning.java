class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    
    public void helper(int index, String s, List<String> partitioning, List<List<String>> result){
        // If we went through all the chars, add the result
        if(index == s.length()){
            result.add(new ArrayList<>(partitioning));
            return;
        }
        for(int i = index; i < s.length(); i++){
            // if current partition is a palindrome
            if(isPalindrome(s, index, i)){
                // then add it to our paritioning
                partitioning.add(s.substring(index, i + 1)); 
                // get all the partitionings that contains this partition
                helper(i + 1, s, partitioning, result); 
                // since we just got all the partitionings that contains this partition, we can remove this partition since for all partitions from now onwards, they won't contain this partition
                partitioning.remove(partitioning.size() - 1); 
            }
        }
    } 
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>(); 
        helper(0, s, new ArrayList<>(), result); 
        return result;
    }
}