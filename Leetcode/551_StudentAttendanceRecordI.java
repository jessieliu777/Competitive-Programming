class Solution {
    public boolean checkRecord(String s) {
        int lateConsec = 0;
        int absent = 0;
        boolean prevLate = false;
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (cur == 'A'){
                absent++;
                prevLate = false;
                lateConsec = 0;
                if (absent >= 2) return false;
            } else if (cur == 'L'){
                if (prevLate || lateConsec == 0) lateConsec++;
                else lateConsec = 0;
                prevLate = true;
                if (lateConsec >= 3) return false;
            } else {
                prevLate = false;
                lateConsec = 0;
            }
        }
        return true;
    }
}