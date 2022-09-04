class Solution {
    public boolean checkDistances(String s, int[] distance) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        // for every letter 
        for (int i = 0; i < 26; i++){
            char letter = alphabets.charAt(i);
            int start = s.indexOf(letter);
            int end = s.lastIndexOf(letter);
            // if char exists in string
            if (start >= 0){
                int dist = end-start-1;
                if (dist != distance[i]) return false;
            }
        }
        return true;
    }
}