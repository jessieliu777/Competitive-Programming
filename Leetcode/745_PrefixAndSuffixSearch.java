class WordFilter {
    TrieNode root;

    // Take "apple" as an example, we will insert add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree.
    // If the query is: prefix = "app", suffix = "le", we can find it by querying our trie for
    // "le{app".
    // We use '{' because in ASCii Table, '{' is next to 'z', so we just need to create new TrieNode[27] instead of 26. Also, compared with tradition Trie, we add the attribute index in class TrieNode.
    class TrieNode {
        TrieNode[] children;
        int index;
        public TrieNode() {
            children = new TrieNode[27]; // 'a' - 'z' and '{'. 'z' and '{' are neighbours in ASCII table
            index = 0;
        }
    }

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            // for ex words[weight] = apple
            // first prefix is the whole word apple{
            String prefix = words[index] + "{";
            // go through every index of suffix apple{
            for (int i = 0; i < prefix.length(); i++) {
                TrieNode cur = root;
                cur.index = index;
                // add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree
                // for go through every index after i that's within the potential suff + pref length, which is 2 * prefix - 1
                // NOTE all the new nodes added have index = index of apple, so when f() is called, finding any of these nodes will return the index of apple
                // start at i = 0, j = 0
                // indexJ = 0, k = 0 (char = a), root.children[0] = new node() 1, cur = node 1
                // j = 1, indexJ = 1, k = 15 (char = p), cur.children[15] = new node 2, cur = node 2
                // j = 2, indexJ = 2, k = 15, cur.children[15] = new node 3, cur = node 3
                // j = 3, indexJ = 3, k = 11, cur.children[11] = new node 4, cur = node 4
                // ... root -> a -> p -> p -> l -> e -> { -> a -> p -> p -> l -> e
                // i = 1, j = 1, indexJ = 15, root.children[15] dne, so new node 11, cur = node 11
                // i = 1, j = 2, indexJ = 15, cur.children [15] dne, new node 12, cur = node 12
                // ...
                // ... after all pairs of i, j get
                // root.children[0] = a -> p -> p -> l -> e -> { -> a -> p -> p -> l -> e
                // root.children[15] = p, p.children = [ple{apple, le{apple]
                // root.children[11] = le{apple
                // root.children[4] = e{apple
                // root.children[26] = {apple
                for (int j = i; j < 2 * prefix.length() - 1; j++) {
                    // since suffix only go up to length, for all the 'extra' indices, cycle the beginning of suffix again. Note when j > suffix.length, we are actually looking at potential prefix not suff anymore.
                    int indexJ = j % prefix.length();
                    // get the alphabet value at indexJ as int
                    int k = prefix.charAt(indexJ) - 'a';
                    // if this alphabet value has not been added as a child of cur, then do so
                    if (cur.children[k] == null) cur.children[k] = new TrieNode();
                    // now this new alphabet is the new cur
                    cur = cur.children[k];
                    cur.index = index;
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        TrieNode cur = root;
        // convert pre, suff to suff{pre. Since all suff s of all words are in the trie repr by suf{word, we only need to look for prefex suf{pre since suf{pre is a prefix of suf{word
        for (char c: (suff + '{' + pref).toCharArray()) {
            // if you cannot find the cur char in trie then it dne
            if (cur.children[c - 'a'] == null) return -1;
            cur = cur.children[c - 'a'];
        }
        return cur.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */