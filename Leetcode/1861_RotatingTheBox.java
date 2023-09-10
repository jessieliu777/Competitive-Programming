class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length, cols = box[0].length;
        
        for(int i = 0; i < rows; ++i){
            // let empty = latest col that's empty, init to be last col
            int empty = cols-1;
            for(int j = cols-1; j >= 0; --j){
                // if cur cell is obstacle, it's not empty and nothing can go through, so mark empty to be pre col of obstacle
                if(box[i][j] == '*') empty = j-1;
                // if cur cell is stone, move stone to empty, mark empty to be one before
                else if(box[i][j] == '#'){
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    --empty;
                }
            }
        }
        
        // return the rotated box
        char[][] box2 = new char[cols][rows];
        for(int i = 0; i < rows; ++i) for(int j = cols-1; j>=0; --j) box2[j][rows-i-1] = box[i][j];
        return box2;
    }
}