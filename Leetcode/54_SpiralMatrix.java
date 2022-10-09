class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int start_row=0, start_col=0;
        int end_row=matrix.length-1;
        int end_col= matrix[0].length-1;
        int total =(end_row+1)*(end_col+1);

        while(end_row>=0 && end_col>=0){
            // keep going right until we need to go down
          for(int i=start_col; i<=end_col && list.size()<total; i++){
            list.add(matrix[start_row][i]);
          } start_row++;
            
            // keep going down until we need to go left
          for(int i=start_row; i<=end_row && list.size()<total; i++){
            list.add(matrix[i][end_col]);
          } end_col--;
            // keep going left until we need to go up
          for(int i=end_col; i>=start_col && list.size()<total; i--){
            list.add(matrix[end_row][i]);
          } end_row--;
            // keep going up until we need to go right
          for(int i=end_row; i>=start_row && list.size()<total; i--){
            list.add(matrix[i][start_col]);
          } start_col++;
        }
        return list;
    }
}