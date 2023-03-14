class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = list1.length + list2.length;
        for (int i=0;i<list1.length;i++) map.put(list1[i], i);
        // for every word in list2
        for (int i=0;i<list2.length;i++) {
            // if this word exists in list 1 and it s index sum is minimal so far
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                // if it s better than before the clear result
                if (i + j < minSum) { 
                    res.clear(); 
                    minSum = i+j; 
                }
                // either way add this common str
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}