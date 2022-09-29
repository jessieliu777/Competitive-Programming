class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if (numRows <= 0)  return result;
        // first row
	    ArrayList<Integer> prev = new ArrayList<Integer>();
        int prevSize = 1;
	    prev.add(1);
	    result.add(prev);
        // For rows 2+
	    for (int i = 2; i <= numRows; i++) {
            // Create another array to store the current triangle value...
		    ArrayList<Integer> curr = new ArrayList<Integer>();
		    curr.add(1);    // first col
            // non-first, non-last cols
		    for (int j = 0; j < prevSize-1; j++) {
			    curr.add(prev.get(j) + prev.get(j + 1));
		    }
            // last col
		    curr.add(1);
		    result.add(curr);
		    prev = curr;
            prevSize++;
	    }
	    return result;
    }
}