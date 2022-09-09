class Solution {
    public double profit(double pass, double total){
        return (pass+1)/(total+1) - pass/total;
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // sort classes by average
        // Max heap (storing the difference in average with an extra student )compared by first value in decreasing order. 
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0])); 
        // add all the elements into the minheap
        for (int[] c: classes){
            maxHeap.offer(new double[]{profit(c[0], c[1]), c[0], c[1]});
        }
        double result = 0.0;
        // for every extra student:
        for (int i = 0; i < extraStudents; i++){
            // add it to the class that gives the most profit
            double[] c = maxHeap.poll();
            maxHeap.offer(new double[]{profit(c[1]+1, c[2]+1), c[1]+1, c[2]+1});
        }
        // calculate average
        double sum = 0.0;
        while (!maxHeap.isEmpty()){
            double[] c = maxHeap.poll();
            sum = sum + (double) c[1]/c[2];
        }    
        return sum/classes.length;
    }
}