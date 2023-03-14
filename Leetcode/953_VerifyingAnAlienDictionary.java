class Solution {
    public boolean isBefore(String w1, String w2, String order){
        int len = Math.min(w1.length(), w2.length());
        for (int i = 0; i < len; i++){
            if (order.indexOf(w1.charAt(i)) < order.indexOf(w2.charAt(i))) return true;
            else if (order.indexOf(w1.charAt(i)) > order.indexOf(w2.charAt(i))) return false;
            
        }
        if (w1.length() > w2.length()) return false;
        return true;
    }
    public boolean isAlienSorted(String[] words, String order) {
        Boolean sorted = true;
        String pre = words[0];
        for (int i = 1; i < words.length; i++){
            sorted = sorted && this.isBefore(pre, words[i], order);
            pre = words[i];
        }
        return sorted;
    }
}