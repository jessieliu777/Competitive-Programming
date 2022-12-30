class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(String s :words){
            if(s.length()>=pref.length() && s.substring(0,pref.length()).equals(pref))count++;
        }
            return count;
    }
}