class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        boolean result = false;
        int direction = 0; // 0 = north, 1 = east, 2 = south, 3 = west
        int count = 0;
        while (count < 4){
            // for every instruction
            for (int i = 0; i < instructions.length(); i++){
                char instruction = instructions.charAt(i);
                // if go
                if (instruction == 'G'){
                    // go in the direction
                    if (direction == 0){
                        // go north
                        y = y+1;
                    } else if (direction == 1){
                        // go east
                        x = x+1;
                    } else if (direction == 2){
                        y = y-1;
                    } else {
                        x = x-1;
                    }
                } else if (instruction == 'L'){
                    direction = (direction - 1);
                    if (direction < 0){
                        direction = 3;
                    }
                } else {
                    direction = (direction + 1) % 4;
                }
            }

            if (x == 0 && y == 0){
                result = true;
                count = 4;
            } else {
                count++;
            }
        }
        return result;
    }
}