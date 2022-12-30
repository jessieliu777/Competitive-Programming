class Solution {
    public String freqAlphabets(String s) {
        StringBuilder output = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){ 
            if(s.charAt(i) == '#'){
                //using ascii, add 'a' to start from the alphabet to get the respective char given int
                output.append((char)('a' 
                    // add '0' for each digit since s is a str and each digit is passed in as char
                    + (s.charAt(i-1) -'0' ) + 10*(s.charAt(i-2)-'0') -1) ); 
                i -= 2; //have skip 2 characters , b/c we already checked it in the above line
            } else output.append((char)('a' + (s.charAt(i) - '0') -1));
        }
        output.reverse(); 
        return output.toString(); 
    }
}