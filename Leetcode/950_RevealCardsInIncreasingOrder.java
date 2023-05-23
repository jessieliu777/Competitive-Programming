class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>(); // let q be a ll of indices
        for (int i=0; i<len; i++) q.add(i);

        int[] res= new int[len];
        // for every index in the result arr
        for (int i=0; i<len; i++){
            // get the next index in the queue, set the value of that index to be the number in deck
            res[q.poll()]=deck[i];
            // get another index, this time we want ths card to be at the 'bottom', so insert it back in the queue
            q.add(q.poll());
        }
        return res;
    }
}