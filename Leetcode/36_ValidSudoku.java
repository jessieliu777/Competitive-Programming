class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowMap = new ArrayList<>();
        List<Set<Character>> colMap = new ArrayList<>();
        List<Set<Character>> boxMap = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            rowMap.add(new HashSet<>());
            colMap.add(new HashSet<>());
            boxMap.add(new HashSet<>());
        }
        // check every row
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.') continue;
                if (rowMap.get(i).contains(board[i][j])){
                    return false;
                } else {
                    rowMap.get(i).add(board[i][j]);
                }
                if (colMap.get(j).contains(board[i][j])){
                    return false;
                } else {
                    colMap.get(j).add(board[i][j]);
                }
                // let 0 be top left corner, 3 be middle left, 6 be bottom left
                int boxIndex = -1;
                // box 0
                if (i < 3) {
                    if (j < 3){
                        boxIndex = 0;
                    } else if (j < 6){
                        boxIndex = 1;
                    } else {
                        boxIndex = 2;
                    }
                } else if (i < 6){
                    if (j < 3){
                        boxIndex = 3;
                    } else if (j < 6){
                        boxIndex = 4;
                    } else {
                        boxIndex = 5;
                    }
                } else {
                    if (j < 3){
                        boxIndex = 6;
                    } else if (j < 6){
                        boxIndex = 7;
                    } else {
                        boxIndex = 8;
                    }
                }
                if (boxMap.get(boxIndex).contains(board[i][j])){
                    System.out.println(i + " " + j);
                    return false;
                } else {
                    boxMap.get(boxIndex).add(board[i][j]);
                }
            }
        }
        return true;
    }
}