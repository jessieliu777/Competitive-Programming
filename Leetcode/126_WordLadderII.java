class Solution {
    private Set<String> dict;
    private String beginWord;
    private String endWord;
    
    private Map<String, List<String>> neighbours = new HashMap<>();
    private List<List<String>> paths = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.dict = new HashSet(wordList);
        dict.add(beginWord); // beginWord may not be in wordList
        
        // if it's endWord isn't in wordList then no paths
        if (!dict.contains(endWord)) return paths;
        this.beginWord = beginWord;
        this.endWord = endWord;
        
        if (!buildMap()) return paths;

        // get all the paths that passes through beginWord. In this case, that starts with beginWord as it's the first word.
        List<String> curPath = new ArrayList<>();
        curPath.add(beginWord);
        collectAllPaths(beginWord, curPath);
        
        return paths;
    }
    
    private void collectAllPaths(String s, List<String> curPath) {
        // if we've reached the endword then we are done
        if (s.equals(endWord)) {
            paths.add(new ArrayList(curPath));
            return;
        }
        
        // for all the neighbours, get all the paths with it, then remove it to get all the paths without it in the future iterations
        for (String next : neighbours.get(s)) {
            curPath.add(next);
            collectAllPaths(next, curPath);
            curPath.remove(curPath.size() - 1);
        }
    }
    
    private boolean buildMap() {
        // starting from endWord, try to reach startWord
        Set<String> backward = new HashSet<>();
        backward.add(endWord);
        
        Set<String> visited = new HashSet<>();
        boolean found = false;
        // while there are still neighbours and we haven't found a path
        while (!backward.isEmpty() && !found) {
            Set<String> temp = new HashSet<>();     
            for (String s : backward) {
                visited.add(s); // mark s as visited
                // for every  neighbour
                for (String neighbour : getNext(s)) {     
                    // skip if it's already visited, or already went through as a neighbour of some node from previous iteration
                    if (backward.contains(neighbour) || visited.contains(neighbour)) continue;
                    if (beginWord.equals(neighbour)) found = true;
                    // add cur to neighbour map of neighbour. No need to do the opposit since we don't need loop, only need to traverse one way during collectAllPaths
                    temp.add(neighbour);
                    neighbours.putIfAbsent(neighbour, new ArrayList<>());
                    neighbours.get(neighbour).add(s);
                }
            }
            backward = temp;
        }
        return found;
    }
    
    private List<String> getNext(String s) {
        char[] arr = s.toCharArray();
        List<String> neighbours = new ArrayList<>();
        // go through every char in s
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            // go thru every char in the alphabet
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) continue;
                // if the alphabet is different than the cur char, then try to replace it
                arr[i] = c;
                String nb = String.valueOf(arr);
                // if the replacement is in dict then it's a neighbour
                if (dict.contains(nb)) neighbours.add(nb);
            }
            // undo the replacement so we can try different ones in future iterations
            arr[i] = ch;
        }
        return neighbours;
    }
}