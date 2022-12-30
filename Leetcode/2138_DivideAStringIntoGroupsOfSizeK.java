class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] res = new String[(s.length() + k - 1) / k];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));//append the character
            if(sb.length() == k) {//made a group of k
                res[i / k] = sb.toString();//put it in res
                sb.setLength(0);//empty the StringBuilder
            }
        }
        if(sb.length() != 0) {//StringBuilder not empty means we have to fill some characters
            while(sb.length() != k) sb.append(fill);//fill till group size is k
            res[res.length - 1] = sb.toString();//put in res
        }
        return res;
    }
}