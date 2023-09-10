class Solution {
    private int gcd(int a,int b){
        if (b==0) return a;
        else return gcd(b, a%b);
    }

    public int maxPoints(int[][] points) {
        /*
        *  A line is y=mx+b
        *  If two points(x1,y1) (x2,y2) are on the same line, then they have the same m, b
        *  We have (y2-y1)=m(x2-x1), m=(y2-y1)/(x2-x1) (=deltaY/deltaX) m is a ratio, b is canceled since b is a constant

        *  If a third point (x3,y3) are on the same line. So we must have y3=mx3+b
        *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=m

        *  Since m is a ratio, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=m
        *  So we can use y0&x0 to track a line;
        */

        // for 2 points or less simply draw line betwee them
        if (points.length<=2) return points.length;
        
        // map (deltaX, deltaY) to number of points on m = deltaY/deltaX <=> map deltaX to (map deltaY to number of points on m = deltaY/deltaX) 
        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result=0;
        // go through every point
        for (int i=0;i<points.length;i++){ 
            // reset map
            map.clear();
            int duplicateCount=0,max=0;
            // go through every potential other point on the same line as this one
            for (int j=i+1;j<points.length;j++){
                int deltaX=points[j][0]-points[i][0];
                int deltaY=points[j][1]-points[i][1];
                if (deltaX==0 && deltaY==0){
                    duplicateCount++;
                    continue;
                }
                // 'reduce' m = deltaY/deltaX to the simpliest form. For ex m = 6/3, gcd = 3, reduce to m = 2/1
                int gcd = gcd(deltaX,deltaY);
                if (gcd!=0){
                    deltaX/=gcd;
                    deltaY/=gcd;
                }
                
                // update deltaX, deltaY in map to include the count of this point
                if (map.containsKey(deltaX)){
                    if (map.get(deltaX).containsKey(deltaY)) map.get(deltaX).put(deltaY, map.get(deltaX).get(deltaY)+1);
                    else map.get(deltaX).put(deltaY, 1);			
                }else{
                    Map<Integer,Integer> deltaYMap = new HashMap<Integer,Integer>();
                    deltaYMap.put(deltaY, 1);
                    map.put(deltaX, deltaYMap);
                }
                // update maxCount for every point paired withh point i
                max=Math.max(max, map.get(deltaX).get(deltaY));
            }
            // update total max count for every pair of points (include duplicate points, since they are also on the same line but have slope 0, 0 with orig point unlike other points on the same line)
            result=Math.max(result, max+duplicateCount+1);
        }
        return result;
    }
}