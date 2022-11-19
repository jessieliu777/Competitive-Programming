class Solution {
    public int minimumDeletions(String s) {
        // make s such that all the a's come before the b's
        int len = s.length();
        int i = 0;
        int countB = 0; // number of 'b' preceding s[i]
        int result = 0;
        while(i<len){
            // if it's an a and there are b's preceding
            if(s.charAt(i) == 'a'){
                if(countB>0){
                    // then we need to delete it 
                    countB--;
                    result++;
                }
            }
            // if it's a b then increment count
            else{
                countB++;
            }
            i++;
        }
        return result;
    }
}