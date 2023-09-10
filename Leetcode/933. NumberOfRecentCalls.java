class RecentCounter {
    TreeMap<Integer, Integer> map;
    public RecentCounter() {
        map = new TreeMap<>();
    }
    
    public int ping(int t) {
        map.put(t, 1 + map.size());
        // tailMap returns the portion of the mapping whose keys are greater than the from_Key.
        return map.tailMap(t - 3000).size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */