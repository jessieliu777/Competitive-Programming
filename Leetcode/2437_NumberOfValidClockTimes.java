class Solution {
    public int countTime(String time) {
        int choices = 1;

        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            choices *= 24;
        }

        else if (time.charAt(0) == '?' && time.charAt(1) != '?') {
            choices *= (time.charAt(1) < '4' ? 3 : 2);
        } 

        else if (time.charAt(1) == '?' && time.charAt(0) != '?') {
            choices *= (time.charAt(0) < '2' ? 10 : 4);
        }

        if (time.charAt(3) == '?') {
            choices *= 6;
        }

        if (time.charAt(4) == '?') {
            choices *= 10;
        }

        return choices;
    }
}