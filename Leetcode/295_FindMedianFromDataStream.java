class MedianFinder {
    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        queueMin = new PriorityQueue<>((a, b) -> b - a);
        queueMax = new PriorityQueue<>(((a, b) -> a - b));
    }
    
    public void addNum(int num) {
        // if there's odd number of items, let min queue have the extra num
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);

            // if min queue has more than 2 items than max queue then we need to move the largest num to max queue
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);

            // if max queue has more than 2 items than min queue then we need to move the smallest num to min queue
            if (queueMin.size() < queueMax.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }
    
    public double findMedian() {
        if (queueMin.size() > queueMax.size()) {
            return queueMin.peek();
        }

        return (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */