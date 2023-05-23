class Solution {
    public boolean isBoomerang(int[][] points) {
        // calculate the slope of AB and AC.
        // K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
        // K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
        // can check if K_AB != K_AC via cross multiply instead of calculate a fraction.
        return (points[0][0] - points[1][0]) * (points[0][1] - points[2][1]) != (points[0][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }
}