class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int count = 0, len = bank.length;
        char[] genes = {'A','C','G','T'};
        Set<String> set = new HashSet<String>(); // all valid mutations
        for(String s : bank) set.add(s);
        Queue<String> queue = new LinkedList<>(); 
        queue.add(start);
        while(!queue.isEmpty()){
            count++;
            int n = queue.size();  
            // for every item in queue
            for(int i=0;i<n;i++){
                // get the gene as char arr
                char[] ch = queue.poll().toCharArray();
                // for every char in gene
                for(int j=0;j<8;j++){
                    char org_char = ch[j];
                    // attempt to try every mutation
                    for(int c =0 ; c<4;c++){
                        ch[j] = genes[c];
                        String str = String.valueOf(ch);
                        // if we've mutated to the end gene and we found the end gene in the set then return the count
                        if(str.equals(end) && set.contains(str))
                            return count;
                        // if current str is not in set the move on
                        if(!set.contains(str)) continue;
                        // if it is in the set, remove it from the set add it to queue
                        set.remove(str);
                        queue.add(str);
                    }
                    ch[j]= org_char;
                }
            }
        }
        return -1;
    }
}