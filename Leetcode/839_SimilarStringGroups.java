class Solution {
    boolean[] visited; // visited[i] = str[i] is visited or not

    boolean isSimilar(String a, String b){
        int count = 0;
        // anagrams a, b are similar iff a and b differ in 2 indices or a == b
        for(int i = 0; i < a.length(); i++) if(a.charAt(i) != b.charAt(i)) count++;
        return (count == 2 || count == 0);
    }

    void dfs(int i, String[] strs){
        visited[i] = true;
        // go through every str, if it's not visited and it's similar to str[i] then that str is part of this group, keep traversing to find its 'neighbours' recursively
        for(int j = 0; j < strs.length; j++){
            if(visited[j]) continue;
            if(isSimilar(strs[i], strs[j])) dfs(j, strs);
        }
    }

    public int numSimilarGroups(String[] strs) {
        int groups = 0, len = strs.length;
        visited = new boolean[len];
        for(int i = 0; i < len; i++){
            if(visited[i]) continue;
            // if str[i] isn't visited, then we need to put it into a new group, visit all the 'neighbours' (similar strings) of str[i]
            groups++;
            dfs(i, strs);
        }
        return groups;
    }
}