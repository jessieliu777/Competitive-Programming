class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() -1 ;
        int j = b.length() -1 ;
        int carry = 0;
        while(i>=0 || j>=0){
            // if there is a carry from the last addition, add it to carry 
            int sum = carry; 
            // get int value of the char from the ascii
            if(i>=0) sum+= a.charAt(i--) - '0'; 
            if(j>=0) sum+= b.charAt(j--) - '0';
             // if sum==2 we have a carry, else no carry
            carry = sum >1 ? 1:0;
            // if sum==2 or sum==0 append 0 (1+1=0 in binary)
            result.append(sum%2); 
        }
        // add leftover carry if there is
        if(carry!=0) result.append(carry); 
        return result.reverse().toString();
    }
}