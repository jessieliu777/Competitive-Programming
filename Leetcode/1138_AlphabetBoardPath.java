class Solution {
    public String alphabetBoardPath(String target) {
        int[] current = {0,0};
        StringBuilder sb = new StringBuilder();
        for(char c : target.toCharArray()) {
            int row = (c - 'a') / 5;
            int col = (c - 'a') % 5;
            
            int xDiff = current[0] - row;
            int yDiff = current[1] - col;
            
            while(yDiff > 0) {
                sb.append("L");
                yDiff--;
            }
            while(xDiff > 0) {
                sb.append("U");
                xDiff--;
            }
            
            while(yDiff < 0) {
                sb.append("R");
                yDiff++;
            }
            while(xDiff < 0) {
                sb.append("D");
                xDiff++;
            }
            
            if(xDiff == 0 && yDiff == 0) sb.append("!");
            
            current = new int[] {row, col};
        }
       
        return sb.toString();
    }
}