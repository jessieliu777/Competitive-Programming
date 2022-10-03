class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()]; // visited[i] == true if i has been visited
        helper(tiles, "", set, visited);
        return set.size()-1;
    }
    
    public void helper(String tiles, String curr, Set<String> set, boolean[] visited){
        set.add(curr);
        for(int i=0; i<tiles.length(); i++){
            if(!visited[i]){
                // mark as visited so we don't double add i
                visited[i]=true;
                // add all the possibilities including tiles[i]
                helper(tiles, curr+tiles.charAt(i), set, visited);
                // unmark it since we won't double add anymore
                visited[i]=false;
            }
        }   
    }
}