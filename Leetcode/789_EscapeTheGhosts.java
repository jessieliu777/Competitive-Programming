class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // you can escape if you can reach target b4 any ghosts
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost: ghosts) if (distance >= Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1])) return false;
        return true;
    }
}