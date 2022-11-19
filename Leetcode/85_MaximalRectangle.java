class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Replace 0 with negative of MAX possible sum in array. And proceed as in the question of finding maximum sum rectangle.
        int ans = 0, m=matrix.length,n = matrix[0].length,INF = -m*n;
        for(int j=0;j<n;j++){
            int[] temp = new int[m];
            // for every submatrix from 0, j to m, n
            for(int z=j;z<n;z++){
                for(int c=0;c<m;c++) temp[c]+= matrix[c][z]=='0'?INF:1;
                ans = Math.max(ans,kadaneAlgo(temp));
            }
        }
        return ans;
    }
    private int kadaneAlgo(int[] arr){
        int max = arr[0], local_max = arr[0];
        for(int i=1;i<arr.length;i++){
            local_max = Math.max(arr[i],local_max+arr[i]);
            max = Math.max(local_max,max);
        }
        return max;
    }
}