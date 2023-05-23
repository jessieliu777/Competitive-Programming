class Solution {
    public double average(int[] salary) {
        double sum = 0d;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum += s;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}