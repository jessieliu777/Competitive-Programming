class Solution {
    public double distToOrigin(int x, int y){
        return Math.sqrt(x*x + y*y);
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        // map the points to the distance
        //priority queue with the distances, points
        PriorityQueue<double[]> minHeap = new PriorityQueue <>(Comparator.comparingDouble(o -> o[0]));
        // add the points to the priority queue
        for (int i = 0; i < points.length; i++){
            int[] point = points[i];
            minHeap.offer(new double[] {distToOrigin(point[0], point[1]), point[0], point[1]});
        }
        for (int i = 0; i < k; i++){
            double[] shortest = minHeap.poll();
            result[i][0] = (int) shortest[1];
            result[i][1] = (int) shortest[2];
        }
        return result;
    }
}