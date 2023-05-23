class ProductOfNumbers {
    List<Integer> stream; // stream[i] the product of all numbers up to and including adding ith num to the stream
    public ProductOfNumbers() {
        stream = new ArrayList(){{
            add(1);
        }};
    }
    
    public void add(int num) {
        // given all nums are non negative. if it's positive add to stream, otherwise reset product cuz 0 * anything is 0
        if (num > 0) stream.add(stream.get(stream.size() - 1) * num);
        else {
            stream = new ArrayList();
            stream.add(1);
        }
    }
    
    public int getProduct(int k) {
        int size = stream.size();
        // product of last k numbers = product of all numbers / product of all number up to (size-k)th number
        return k < size ? stream.get(size - 1) / stream.get(size - k - 1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */