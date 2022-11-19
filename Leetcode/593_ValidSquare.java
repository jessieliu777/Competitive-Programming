class Solution {
    
    double line1 = 0;
    double line2 = 0;
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {       
        return ( decider(p1,p2) && decider(p1,p3) && decider(p1,p4) && decider(p2,p3) && decider(p2,p4) && decider(p3,p4));
    }
    
    public boolean decider(int[] x1, int[] x2) {  
        // dist = (delta x)^2 + (delta y)^2
        double dist = Math.sqrt( Math.pow( (x2[0]-x1[0]),2) + Math.pow( (x2[1]-x1[1]),2) );
        // if these 2 lines are the same line then no square
        if(dist == 0){
            return false;
        }
        // if line1 is not set then set line1 to be dist
        else if(line1 == 0) {
            line1 = dist;
        } 
        // if line1 is set but line2 isn't then set line2 to be dist
        else if(line2 == 0 && dist != line1) {
            line2 = dist;
        } 
        // there can only be 2 lines since the lines are either parallel or perpendicular
        else if(dist != line1 && dist != line2) {
            return false;
        }
        return true;
        
    }
}