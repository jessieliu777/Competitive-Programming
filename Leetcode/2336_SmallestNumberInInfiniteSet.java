class SmallestInfiniteSet {
    int smallest;
    TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        smallest = 1;
        set = new TreeSet<>();
    }
    
    public int popSmallest() {
        if (set.isEmpty()) return smallest++;
        return set.pollFirst();
    }
    
    public void addBack(int num) {
        if (num < smallest) set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */