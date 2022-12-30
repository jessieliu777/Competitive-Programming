class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder res= new StringBuilder();
        // for every digit
        for (int i=0; i<num.length(); i++){
            char cur= num.charAt(i);
            // if there's nothing in the resulting num and cur is 0 then it would be a leading 0, so skip it
            if (res.length()==0 && cur=='0') continue;
            // while we can delete chars, the resulting num's last digit is more than current digit, then we should delete the last digit
            while (k>0 && res.length()>0 && res.charAt(res.length()-1)>cur ){
                res.deleteCharAt(res.length()-1);
                k--;
            }
            // add the current digit to the resulting num
            res.append(cur);
        }
        // skip leading 0's
        while (res.length()>0 && res.charAt(0) == '0') res.deleteCharAt(0);
        // if there's still more removing to do, then keep removing the last digit
        while (k-->0 && res.length()>0) res.deleteCharAt(res.length()-1);
        return res.length() == 0 ? "0" : res.toString();
    }
}