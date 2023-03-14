class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int SIZE;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        SIZE = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            // remove and put again so it becomes the most recent
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // if map contains key, then remove and put again so it becomes the most recent
        if(map.containsKey(key)) map.remove(key);
        // otherwise if it surpasses capacity, then remove the least recent (the first entry in map)
        else if(map.size() + 1 > SIZE)  map.remove(map.keySet().iterator().next());
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */