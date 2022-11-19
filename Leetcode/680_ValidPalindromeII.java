class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }
    
    public boolean isPalindrome(final String s, int leftIndex, int rightIndex, final boolean isCharacterDeleted){
        
        while(leftIndex < rightIndex){
            // for every left, right index if they aren't equal 
            if(s.charAt(leftIndex) != s.charAt(rightIndex)){
                // if we've already deleted a char then we can't delete again
                if(isCharacterDeleted){
                    return false;
                }
                // otherwise pretend to delete the char by skipping over it, and continue on
                return isPalindrome(s, leftIndex + 1, rightIndex, true) || isPalindrome(s, leftIndex, rightIndex - 1, true);
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}