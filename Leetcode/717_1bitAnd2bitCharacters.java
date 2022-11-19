class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i < bits.length; i++){
            // if we got to the last char then the previous char is skipped so the prev char is part of a 2 bit seq. Then this char must be one bit if it's 0
            if(bits[i] == 0 && i == bits.length - 1) return true; 
            // That means a start of a character (10 or 11) so skip it 
            else if(bits[i] == 1) i++; 
        }
        return false;
    }
}