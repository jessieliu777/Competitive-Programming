/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> queue = new LinkedList();
    public NestedIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.poll() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void helper(List<NestedInteger> list){
        if (list == null) return;
        for (NestedInteger item: list){
            if (item.isInteger()) queue.offer(item.getInteger());
            else helper(item.getList());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */