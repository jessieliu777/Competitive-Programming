class Solution {
    public boolean canTransform(String start, String end) {
        int len = end.length();
        int startIndex = 0, targetIndex = 0;
        while (startIndex <= len && targetIndex <= len){
            // skip all the X's in both start and target
            while (startIndex < len && start.charAt(startIndex) == 'X') startIndex++;
            while (targetIndex < len && end.charAt(targetIndex) == 'X') targetIndex++;
            
            // if one of the strings reached the end then both need to reach the end for the change to be possible. If not, then since one of them cannot be moved any furthur start cannot change to target using anymore operations
            if(targetIndex == len || startIndex == len) return targetIndex == len && startIndex == len;
            
            // if the cur character (after skipping X's in both strs isn't the same, then moving position isn't gonna make them the same, so return false)
            if(start.charAt(startIndex) != end.charAt(targetIndex)) return false;
            
            // if cur target is L but it's to the right of start, given we can only move L right it's not possible to move L to the right to reach target position, so return false
            if (end.charAt(targetIndex) == 'L') {
                if (startIndex < targetIndex) return false;
            }
            // if cur target is R (since it's not L and all X got skipped), and target is to the left of start then same as before given we cannot move R any lefter, return false
            else if (targetIndex < startIndex) return false;
            
            startIndex++;
            targetIndex++;
        }
        return true;
    }
}