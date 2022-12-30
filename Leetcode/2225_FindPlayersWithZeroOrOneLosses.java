class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		int n = matches.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			map.merge(matches[i][1], 1, Integer::sum);
		}
        // get all the places who lost 1 match
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == 1) {
				list1.add(e.getKey());
			}
		}
        // for all match winners, if they didn't lose then add to the list of no loss
		TreeSet<Integer> noLoss = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(matches[i][0])) {
				noLoss.add(matches[i][0]);
			}
		}
		List<Integer> list2 = new ArrayList<>(noLoss);
		list.add(list2);
		list.add(list1);
		return list;
    }
}