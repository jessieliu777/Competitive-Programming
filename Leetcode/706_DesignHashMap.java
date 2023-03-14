class MyHashMap {
    // The "easy" solution for this problem is simply to create an array large enough to accommodate the entire range of keys. This would seem to be the intended first solution, since the range of allowed keys is non-negative and constrained to 10^6, which is not unmanageable.
    
    // While this is probably the correct answer for an easy problem, it doesn't really get to the heart of what a hashmap really is. Hashmaps were created to speed up the lookup time of data to a hopefully O(1) time. Arrays do this naturally with index lookups, but it becomes more complicated if you're trying to look up an entry by some other non-index value instead.
    
    // We can see from the basic solution here that its easy enough to mimic a key lookup if the keys themselves are integers that are constrained enough to act as their own indexes. But what if they're not? We can still use an Array to store the data, but we must first find a way to transform the key into an index. For that, we look to a hashing function. Hashing functions exist to convert data into a randomized, but reproduceable, integer version of themselves.
    
    // In this case, we can use a hashing function to convert the key into an integer within the bounds of our hashmap array's index range. In an ideal situation, that would allow us to reduce the size of the hashmap array to the maximum number of entries, which is 10^4. Unfortunately, however, it's always possible for collisions to exist when two keys devolve to the same integer via the hashing function.
    
    // To deal with collisions, we can just make each of our hashmap array's elements a linked list. This will allow us to treat them like a simple stack, where we look first at the most recently added node and then move to the next until we find the correct key.
    
    // Since navigating a linked list will drop our lookup time past O(1), the goal of a good hashing function is to randomize the keys' hashes enough to limit collisions as much as possible for a given hashmap array size, thus keeping down the average lookup time complexity.
    
    // Therefore, the size of our hashmap array should probably be at least equal to the number of entries. Increasing the size of the hashmap array will naturally reduce collisions (and therefore time complexity) at the expense of space complexity, and vice versa. The tradeoff is highly dependent on the quality of the hashing function.
    
    // There are many, many hashing functions out there, but for this problem we'll use a very simple multiplicative hashing function utilizing a large prime multiplier and then modulo the result to the desired size (also a prime) of our hashmap array. This should hopefully result in an even distribution of the entries throughout the hashmap array.
    
    // Implementation:
    // Python has deque and Java has LinkedList that can do the work of the linked list management, but it comes at the cost of efficiency. In this case, it's not really worth using over a custom ListNode class implementation.
    
        class ListNode {
            int key, val;
            ListNode next;
            public ListNode(int key, int val, ListNode next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
        static final int size = 19997;
        static final int mult = 12582917;
        ListNode[] data;
    
        public MyHashMap() {
            this.data = new ListNode[size];
        }
    
        private int hash(int key) {
            return (int)((long)key * mult % size);
        }
        
        // First remove() any earlier instance of that key to avoid chaining multiple versions of a key definition in our linked list. Then we simply form a new ListNode at the head of the proper hashmap bucket, pushing any others back.
        public void put(int key, int value) {
            remove(key);
            int hashedKey = hash(key);
            // make a new node that points to the old data[hashedKey]
            ListNode node = new ListNode(key, value, data[hashedKey]);
            data[hashedKey] = node;
        }
        
        // We just hash() our key, access the corresponding bucket in our hashmap array (data), and navigate through the linked list (if necessary) and return the correct val, or -1 if the key is not found.
        public int get(int key) {
            int hashedKey = hash(key);
            ListNode node = data[hashedKey];
            for (; node != null; node = node.next) if (node.key == key) return node.val;
            return -1;
        }
        
        // Similar to the get() method, except that we need to find and stitch together the nodes on either side of the node that matches the key, removing it from the linked list entirely.
        public void remove(int key) {
            int hashedKey = hash(key);
            ListNode node = data[hashedKey];
            // if no such hashed key do nothing
            if (node == null) return;
            // if such key is at the top of linkedList then move the head to the next node
            else if (node.key == key) data[hashedKey] = node.next;
            // otherwise go through all the nodes, when we found the key make the prev point to the next
            // it is guarenteed the key is not the first node as it would've been done earlier. It doesn't matter if key DNE as nothing would've returned.
            else for (; node.next != null; node = node.next)
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
        }
    }
    
    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */