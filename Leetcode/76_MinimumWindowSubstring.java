class Solution {
    public String minWindow(String s, String t) {        
        int sLen = s.length();
        int tLen = t.length();
        
        int freq[] = new int[128]; // stores the frequency of every char
        int characters = 0; // the number of chars in t
        
        // stores the frequency of every char in t
        for(int i=0;i<tLen;i++){
            freq[t.charAt(i)]++;
            characters++;
        }
        
        int start =0, end = 0;
        int min_length = sLen+1; // the min window length
        int start_index = 0; // the start index of the min window substr
        
        while(end < sLen){
            // if s[end] appears in freq then we already counted it so reduce char count and freq count by 1 and move on
            if(freq[s.charAt(end)]>0) characters--;
            freq[s.charAt(end)]--;
            end++;
            
            // if we went through all the chars
            while(characters==0){
                // if the substring we went through all the chars is smaller than the previous min_length then update it
                if(min_length>end-start){
                    min_length = end-start;
                    start_index = start;
                }
                // move the window from start to start+1, so we need to add the freq, and char count if freq is more than 0, then move to the next start
                freq[s.charAt(start)]++;
                if(freq[s.charAt(start)]>0){
                    characters++;
                }
                start++;
            }
        }
        
        return min_length == sLen+1 ? "" : s.substring(start_index,start_index+min_length);
    }
}