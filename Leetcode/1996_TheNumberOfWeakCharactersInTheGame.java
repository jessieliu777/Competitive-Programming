class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // sort properties by attack (descending) first then defense (ascending)
        // this forces the weaker to be after the stronger
        Arrays.sort(properties, (a,b) -> (a[0]!=b[0]) ? b[0]-a[0] : a[1]-b[1]);
        // initialize the max stats to be the first character's
        // since we already sorted by attack first, then the first character cannot be weak since its attack is not strictly less than anyone and they must have the highest attack
        int defenseMax = properties[0][1];
        int weak = 0;
        // go through all the characters afterwards
        for (int i = 1; i < properties.length; i++){
            if (properties[i][1] < defenseMax){
                if (properties[i][0] < properties[0][0]){
                    weak++;
                }
            } else {
                defenseMax = properties[i][1];
            }
        }
        return weak;
    }
}