class Solution {
    int index = 0;
    public String decodeString(String s) {
        int n = s.length();
        int duplicate = 0;
    	StringBuilder sb = new StringBuilder();
    	while (index < n) {
    		char c = s.charAt(index);
    		if (c >= 'a' && c <= 'z') {
    			sb.append(c);
    		} else if (c >= '0' && c <= '9') {
    			duplicate = duplicate * 10 + (c - '0');
    		} 
            // skip [, duplicate the string after [
            else if (c == '[') {
    			index++; 
    			String str = decodeString(s);
    			for (int i = 0; i < duplicate; i++)
   					sb.append(str);
    			duplicate = 0;  // reset the value for the next input
    		} 
            // skip ], already done substring inside [], so exit
            else if (c == ']') break;
    		index++;
    	}
    	return sb.toString();
    }
}