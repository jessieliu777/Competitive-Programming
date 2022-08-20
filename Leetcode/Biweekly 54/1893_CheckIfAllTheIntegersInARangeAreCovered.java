class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] result = new boolean[right-left+1];
        for (int j = left; j <= right; j++){
            result[j-left] = false;
            for (int i = 0; i < ranges.length; i++){
                if (ranges[i][0] <= j && j <= ranges[i][1]){
                    result[j-left] = true;
                }
            }
        }
        for (int k = 0; k < result.length; k++){
            if (result[k] == false){
                return false;
            }
        }
        return true;
    }
}