class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        // move downward -> vertical
        // move upward -> diagonal
        int len = s.length();
        // 0 means down, 1 means up
        int direction = 0;
        // we need a different string for each row
        // (at the end we can just concat them together)
        List<StringBuilder> strs = new ArrayList<>(numRows);
        int cur = 0;
        for (int i = 0; i < numRows; i++){
            strs.add(new StringBuilder());
        }
        for (int j = 0; j < len; j++){
            strs.get(cur).append(String.valueOf(s.charAt(j)));
            if (direction == 0){
                cur++;
                if (cur >= numRows){
                    direction++;
                    cur = numRows-1-1;
                }
            } else {
                cur--;
                if (cur < 0){
                    direction--;
                    cur = 1;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < numRows; k++){
            result.append(strs.get(k).toString());
        }
        return result.toString();
    }
}