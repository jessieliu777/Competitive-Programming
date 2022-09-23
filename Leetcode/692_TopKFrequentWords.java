class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.merge(word, 1, Integer::sum);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> 
            {
                int freq1 = map.get(s1);
                int freq2 = map.get(s2);
                if (freq1 == freq2) return s2.compareTo(s1);
                return freq1-freq2;
            }                                       
        );
        // add everything in map to q, but keep the size within k
        for (String key: map.keySet()){
            pq.add(key);
            if (pq.size() > k){
                pq.remove();
            }
        }
        
        LinkedList<String> result = new LinkedList<>();
        while(!pq.isEmpty()) result.addFirst(pq.remove());
        return result;
    }
}