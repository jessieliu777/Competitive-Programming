class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        Set<String> set = new HashSet<>(wordList);
        // if it's not possible to get to the endword, we are done
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>(); 
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
            count++;
            int n = queue.size();  
            // for every str in queue
            for(int i=0;i<n;i++){
                String word = queue.poll();
                // if we found endWord we are done
                if (word.equals(endWord)) return count;
                // for every position in the cur wor
                for(int j=0; j<word.length(); j++){
                    // attempt every possible char
                    for(int k = 'a'; k <= 'z'; k++){
                        // replace the jth letter with the possible char
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k;
                        String str = new String(arr);

                        // if the new str is in the wordlist and we haven't visited it before, put it in the queue so we can get to it
                        if(set.contains(str) && !visited.contains(str)){
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
        }
        return 0;
    }
}