class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // for every row in triangle
        List<List<Integer>> sum = new ArrayList<>();

        for (int i = 0; i < triangle.size(); i++){
            List<Integer> row = triangle.get(i);
            List<Integer> rowSum = new ArrayList<>();
            // get the minimum sum from top until each num
            if (i == 0){
                rowSum.add(row.get(i));
            } else{
                for (int j = 0; j<row.size(); j++) {
                    if (j == row.size()-1){
                        rowSum.add(sum.get(i-1).get(j-1)+row.get(j));
                    } else if (j == 0) {
                        rowSum.add(sum.get(i-1).get(j)+row.get(j));
                    } else {
                        int pre0 = sum.get(i-1).get(j-1);
                        int pre1 = sum.get(i-1).get(j);
                        rowSum.add(Math.min(pre0, pre1)+row.get(j));

                    }
                    
                }
            }
            sum.add(rowSum);
        }
        return Collections.min(sum.get(sum.size()-1));
    }
}